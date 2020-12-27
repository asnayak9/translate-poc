package com.shree.poc.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shree.poc.TaxType;
import com.shree.poc.entities.TaxAccount;
import com.shree.poc.entities.TaxTypes;
import com.shree.poc.entities.Taxbook;
import com.shree.poc.repositories.TaxBookRepository;
import com.shree.poc.vos.TaxAccountVo;
import com.shree.poc.vos.TaxEntryVo;

@Service
public class TaxAccountServiceImpl implements TaxAccountService {

	private static final Logger LOG = LoggerFactory.getLogger(TaxAccountServiceImpl.class);
	
	private @Autowired TaxBookRepository taxBookRepo;
	
	@Override
	public void create(TaxEntryVo newTax) {
		LOG.info("create() called");
		LOG.debug("create() called with: {}", newTax);
		
		Taxbook tax = convertVoToEntity(newTax);
		
		taxBookRepo.save(tax);
	}
	
	@Override
	public TaxEntryVo findOne(Long sno) {
		LOG.info("findOne() called");
		LOG.debug("findOne() called with: {}", sno);
		
		Optional<Taxbook> tbOptional = taxBookRepo.findById(sno);
		if(tbOptional.isPresent()) {
			return convertListToMap(new TaxEntryVo(tbOptional.get()));
		}
		
		throw new IllegalArgumentException("Invalid tax entry id: "+sno);
	}
	
	@Override
	public void delete(Long sno) {
		LOG.info("delete() called");
		LOG.debug("delete() called with: {}", sno);
		
		if(taxBookRepo.existsById(sno)) {
			taxBookRepo.deleteById(sno);
		}
	}
	
	@Override
	public void update(TaxEntryVo newTax) {
		LOG.info("update() called");
		LOG.debug("update() called with: {}", newTax);
		
		Taxbook tax = convertVoToEntity(newTax);
		tax.setTaxbookId(newTax.getTaxbookId());
		
		taxBookRepo.save(tax);
		
		LOG.info("Updated tax details");
	}
	
	private Taxbook convertVoToEntity(TaxEntryVo newTax) {
		Taxbook tb = new Taxbook();
		tb.setSno(newTax.getSno());
		tb.setDemandNo(newTax.getDemandNo());
		tb.setDoorNo(newTax.getDoorNo());
		tb.setFhName(newTax.getFhName());
		tb.setHeight(newTax.getHeight());
		tb.setHouseType(newTax.getHouseType());
		tb.setLength(newTax.getLength());
		tb.setName(newTax.getName());
		tb.setTaxAccount(toTaxAccounts(tb, newTax));
		tb.setTotal(newTax.getTotal());
		return tb;
	}

	private List<TaxAccount> toTaxAccounts(Taxbook tb, TaxEntryVo newTax) {
		List<TaxAccount> taxAccList = new ArrayList<>();
		TaxAccount ta = null;
		for(TaxAccountVo nt : newTax.getTaxAccount()) {
			ta = new TaxAccount();
			ta.setId(nt.getId());
			ta.setHouseTaxArrear(nt.getHouseTaxArrear());
			ta.setHouseTaxCurrent(nt.getHouseTaxCurrent());
			ta.setLibertyTaxArrear(nt.getLibertyTaxArrear());
			ta.setLibertyTaxCurrent(nt.getLibertyTaxCurrent());
			ta.setTaxbook(tb);
			
			Optional<TaxType> ttOptional = TaxType.fromString(nt.getTaxType());
			if(!ttOptional.isPresent()) {
				throw new RuntimeException("Invalid tax type supplied");
			}
			
			TaxType tt = ttOptional.get();
			TaxTypes taxTyp = new TaxTypes();
			taxTyp.setTaxTypeId(Long.valueOf(tt.getTypeId()));
			taxTyp.setTypeName(tt.getTypeName());
			
			ta.setTaxType(taxTyp);
			ta.setTotalTaxArrear(nt.getTotalTaxArrear());
			ta.setTotalTaxCurrent(nt.getTotalTaxCurrent());
			
			taxAccList.add(ta);
		}
		return taxAccList;
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
	        collection.add(convertListToMap(new TaxEntryVo(tb)));
	    }
	}

	private TaxEntryVo convertListToMap(TaxEntryVo taxEntryVo) {
		List<TaxAccountVo> taxAccList = taxEntryVo.getTaxAccount();
		Map<String, TaxAccountVo> grouped = new HashMap<>();
		for(TaxAccountVo t: taxAccList) {
			grouped.put(t.getTaxType(), t);
		}
		
		taxEntryVo.setTaxAccountMap(grouped);
		return taxEntryVo;
	}
}
