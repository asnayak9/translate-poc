package com.shree.poc.services;

import java.util.List;

import com.shree.poc.entities.Taxbook;
import com.shree.poc.vos.TaxEntryVo;

public interface TaxAccountService {

	void save(Taxbook newTax);
	List<TaxEntryVo> findAll();
	
}
