package com.shree.poc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tax_account")
public class TaxAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@ManyToOne
	@JoinColumn(name="taxbook_id")
	private Taxbook taxbook;
	
	@OneToOne
	@JoinColumn(name="tax_type_id")
	private TaxTypes taxType;
	
	@Column(name = "house_tax_arrear")
	private Integer houseTaxArrear;
	
	@Column(name = "house_tax_current")
	private Integer houseTaxCurrent;
	
	@Column(name = "liberty_tax_arrear")
	private Integer libertyTaxArrear;
	
	@Column(name = "liberty_tax_current")
	private Integer libertyTaxCurrent;
	
	@Column(name = "total_tax_arrear")
	private Integer totalTaxArrear;
	
	@Column(name = "total_tax_current")
	private Integer totalTaxCurrent;
	
	public TaxAccount() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TaxTypes getTaxType() {
		return taxType;
	}

	public void setTaxType(TaxTypes taxType) {
		this.taxType = taxType;
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

	public Taxbook getTaxbook() {
		return taxbook;
	}

	public void setTaxbook(Taxbook taxbook) {
		this.taxbook = taxbook;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaxAccount other = (TaxAccount) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaxAccount [id=");
		builder.append(id);
		builder.append(", taxAccount=");
		builder.append(taxbook.getName());
		builder.append(", taxType=");
		builder.append(taxType.getTypeName());
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
