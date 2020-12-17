package com.shree.poc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shree.poc.entities.Book;

@Controller
@RequestMapping("/api/tax")
public class TaxBookController {

	private static final Logger LOG = LoggerFactory.getLogger(TaxBookController.class);
	
	@RequestMapping("/")
    public String index(Model model){
    	LOG.info("/api/tax home endpoint triggered.");
        
        model.addAttribute("book", new Book());
        return "tax-entry";
    }
}
