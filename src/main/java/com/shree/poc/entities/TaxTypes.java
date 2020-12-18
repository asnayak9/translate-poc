package com.shree.poc.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tax_types")
public class TaxTypes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tax_type_id")
	private long taxTypeId;

	@Column(name = "type_name")
	private String typeName;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tax_type_id", referencedColumnName = "id")
	private TaxAccount taxAccount;
	
	public TaxTypes() {}

	public long getTaxTypeId() {
		return taxTypeId;
	}

	public void setTaxTypeId(long taxTypeId) {
		this.taxTypeId = taxTypeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaxTypes [taxTypeId=");
		builder.append(taxTypeId);
		builder.append(", typeName=");
		builder.append(typeName);
		builder.append("]");
		return builder.toString();
	}
	
	
}
