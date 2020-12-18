package com.shree.poc.controllers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Abhishek Nayak
 *
 */
@Controller
public class HomeContoller {

	private static final Logger LOG = LoggerFactory.getLogger(HomeContoller.class);
	
	private String appMode;

    @Autowired
    public HomeContoller(Environment environment){
    	LOG.info("Home controller initialized.");
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping("/")
    public String index(Model model){
    	LOG.info("home endpoint triggered.");
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Shree");
        model.addAttribute("mode", appMode);
        return "index";
    }
}
