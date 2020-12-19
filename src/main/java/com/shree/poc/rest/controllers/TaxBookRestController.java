package com.shree.poc.rest.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shree.poc.services.TaxAccountService;
import com.shree.poc.vos.TaxEntryVo;
import com.shree.poc.vos.TaxResponse;

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
	
	@PostMapping("/create")
	public ResponseEntity<TaxResponse> createNewTaxEntry(@RequestBody TaxEntryVo newTax){
		LOG.info("New tax entry called");
		LOG.debug("New tax entry called with: {}", newTax);
		
		taxBookSvc.create(newTax);
		
		return new ResponseEntity<>(TaxResponse.of("Successfully created new tax entry") , HttpStatus.OK);
	}
}
