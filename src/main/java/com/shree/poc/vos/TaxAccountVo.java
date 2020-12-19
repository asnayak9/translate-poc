package com.shree.poc.vos;

import java.util.Optional;

import com.shree.poc.entities.TaxAccount;
import com.shree.poc.entities.TaxTypes;

public class TaxAccountVo {

	private long id;

	private String taxType;
	
	private Integer houseTaxArrear;
	
	private Integer houseTaxCurrent;
	
	private Integer libertyTaxArrear;
	
	private Integer libertyTaxCurrent;
	
	private Integer totalTaxArrear;
	
	private Integer totalTaxCurrent;
	
	public TaxAccountVo() {}

	public TaxAccountVo(TaxAccount taxAccount) {
		this.houseTaxArrear = taxAccount.getHouseTaxArrear();
		this.houseTaxCurrent = taxAccount.getHouseTaxCurrent();
		this.id = taxAccount.getId();
		this.libertyTaxArrear = taxAccount.getLibertyTaxArrear();
		this.houseTaxCurrent = taxAccount.getLibertyTaxCurrent();

		Optional<TaxTypes> taxType = Optional.ofNullable(taxAccount.getTaxType());
		
		this.taxType = taxType.isPresent()? taxType.get().getTypeName() : " ";
		this.totalTaxArrear = taxAccount.getTotalTaxArrear();
		this.totalTaxCurrent = taxAccount.getTotalTaxCurrent();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getHouseTaxArrear() {
		return houseTaxArrear;
	}

	public void setHouseTaxArrear(Integer houseTaxArrear) {
		this.houseTaxArrear = houseTaxArrear;
	}

	public Integer getHouseTaxCurrent() {
		return houseTaxCurrent;
	}

	public void setHouseTaxCurrent(Integer houseTaxCurrent) {
		this.houseTaxCurrent = houseTaxCurrent;
	}

	public Integer getLibertyTaxArrear() {
		return libertyTaxArrear;
	}

	public void setLibertyTaxArrear(Integer libertyTaxArrear) {
		this.libertyTaxArrear = libertyTaxArrear;
	}

	public Integer getLibertyTaxCurrent() {
		return libertyTaxCurrent;
	}

	public void setLibertyTaxCurrent(Integer libertyTaxCurrent) {
		this.libertyTaxCurrent = libertyTaxCurrent;
	}

	public Integer getTotalTaxArrear() {
		return totalTaxArrear;
	}

	public void setTotalTaxArrear(Integer totalTaxArrear) {
		this.totalTaxArrear = totalTaxArrear;
	}

	public Integer getTotalTaxCurrent() {
		return totalTaxCurrent;
	}

	public void setTotalTaxCurrent(Integer totalTaxCurrent) {
		this.totalTaxCurrent = totalTaxCurrent;
	}
	
	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaxAccountVo [id=");
		builder.append(id);
		builder.append(", houseTaxArrear=");
		builder.append(houseTaxArrear);
		builder.append(", houseTaxCurrent=");
		builder.append(houseTaxCurrent);
		builder.append(", libertyTaxArrear=");
		builder.append(libertyTaxArrear);
		builder.append(", libertyTaxCurrent=");
		builder.append(libertyTaxCurrent);
		builder.append(", totalTaxArrear=");
		builder.append(totalTaxArrear);
		builder.append(", totalTaxCurrent=");
		builder.append(totalTaxCurrent);
		builder.append("]");
		return builder.toString();
	}
	
	
}
