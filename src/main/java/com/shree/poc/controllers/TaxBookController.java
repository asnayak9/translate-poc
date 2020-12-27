package com.shree.poc.controllers;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shree.poc.services.TaxAccountService;


@Controller
public class TaxBookController {

	private static final Logger LOG = LoggerFactory.getLogger(TaxBookController.class);
	
	private @Autowired TaxAccountService taxSvc;
	
	@RequestMapping("/api/tax/")
    public String index(Model model){
    	LOG.info("/api/tax endpoint triggered.");
        model.addAttribute("allTaxAccs", taxSvc.findAll());
        return "tax-entry";
    }
	
	@RequestMapping("/api/tax/update/{taxbookId}")
    public String updateTaxDetails(@PathVariable("taxbookId")Long taxbookId, Model model){
    	LOG.info("/api/tax/update endpoint triggered.");
        model.addAttribute("taxEntry", taxSvc.findOne(taxbookId));
        return "tax-entry-update";
    }
	
	@ModelAttribute("houseTypes")
	public List<String> houseTypes(){
		return Arrays.asList("Concrete", "IAY", "ASBESTOS");
	}
}
