package com.shree.poc.services;

import java.util.List;

import com.shree.poc.vos.TaxEntryVo;

public interface TaxAccountService {

	List<TaxEntryVo> findAll();
	void create(TaxEntryVo newTax);
	
}
