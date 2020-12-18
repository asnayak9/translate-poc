package com.shree.poc.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shree.poc.entities.Taxbook;
import com.shree.poc.repositories.TaxBookRepository;
import com.shree.poc.vos.TaxEntryVo;

@Service
public class TaxAccountServiceImpl implements TaxAccountService {

	private static final Logger LOG = LoggerFactory.getLogger(TaxAccountServiceImpl.class);
	
	private @Autowired TaxBookRepository taxBookRepo;
	
	@Override
	public void save(Taxbook newTax) {
		LOG.info("save() called");
		LOG.debug("save() called with: {}", newTax);
		taxBookRepo.save(newTax);
	}

	@Override
	public List<TaxEntryVo> findAll() {
		LOG.info("findAll() called");
		List<TaxEntryVo> taxBook = new ArrayList<TaxEntryVo>();
		addAll(taxBook, taxBookRepo.findAll());
		return taxBook;
	}

	public void addAll(Collection<TaxEntryVo> collection, Iterable<Taxbook> iterator) {
	    for (Taxbook tb : iterator) {
	        collection.add(new TaxEntryVo(tb));
	    }
	}
}
