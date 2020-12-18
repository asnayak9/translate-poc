package com.shree.poc.rest.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shree.poc.entities.Taxbook;
import com.shree.poc.services.TaxAccountService;
import com.shree.poc.vos.TaxEntryVo;

@RestController
@RequestMapping("/api/tax")
public class TaxBookRestController {

	private static final Logger LOG = LoggerFactory.getLogger(TaxBookRestController.class);
	
	private @Autowired TaxAccountService taxBookSvc;
	
	@GetMapping("/all")
	public ResponseEntity<List<TaxEntryVo>> allTaxBooks(){
		LOG.info("Get all tax accounts called");
		return new ResponseEntity<List<TaxEntryVo>>(taxBookSvc.findAll(), HttpStatus.OK);
	}
}
