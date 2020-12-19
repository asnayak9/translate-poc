package com.shree.poc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shree.poc.services.TaxAccountService;


@Controller
public class TaxBookController {

	private static final Logger LOG = LoggerFactory.getLogger(TaxBookController.class);
	
	private @Autowired TaxAccountService taxSvc;
	
	@RequestMapping("/api/tax/")
    public String index(Model model){
    	LOG.info("/api/tax home endpoint triggered.");
        model.addAttribute("allTaxAccs", taxSvc.findAll());
        return "tax-entry";
    }
}
