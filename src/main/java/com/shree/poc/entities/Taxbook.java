package com.shree.poc.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "taxbook")
public class Taxbook {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "taxbook_id")
	private long taxbookId;

	@Column(name = "s_no")
	private Integer sno;

	@Column(name = "demand_no")
	private Integer demandNo;
	
	@Column(name = "door_no")
	private Integer doorNo;
	
	@Column(name = "house_type")
	private String houseType;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "fh_name")
	private String fhName;
	
	@Column(name = "height")
	private Integer height;
	
	@Column(name = "length")
	private Integer length;
	
	@Column(name = "total")
	private Integer total;
	
	@OneToMany(mappedBy = "taxbook", cascade = CascadeType.ALL)
	private List<TaxAccount> taxAccount;
	
	public Taxbook() {}

	public long getTaxbookId() {
		return taxbookId;
	}

	public void setTaxbookId(long taxbookId) {
		this.taxbookId = taxbookId;
	}

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public Integer getDemandNo() {
		return demandNo;
	}

	public void setDemandNo(Integer demandNo) {
		this.demandNo = demandNo;
	}

	public Integer getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(Integer doorNo) {
		this.doorNo = doorNo;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFhName() {
		return fhName;
	}

	public void setFhName(String fhName) {
		this.fhName = fhName;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<TaxAccount> getTaxAccount() {
		return taxAccount;
	}

	public void setTaxAccount(List<TaxAccount> taxAccount) {
		this.taxAccount = taxAccount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (taxbookId ^ (taxbookId >>> 32));
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
		Taxbook other = (Taxbook) obj;
		if (taxbookId != other.taxbookId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Taxbook [taxbookId=");
		builder.append(taxbookId);
		builder.append(", sno=");
		builder.append(sno);
		builder.append(", demandNo=");
		builder.append(demandNo);
		builder.append(", doorNo=");
		builder.append(doorNo);
		builder.append(", houseType=");
		builder.append(houseType);
		builder.append(", name=");
		builder.append(name);
		builder.append(", fhName=");
		builder.append(fhName);
		builder.append(", height=");
		builder.append(height);
		builder.append(", length=");
		builder.append(length);
		builder.append(", total=");
		builder.append(total);
		builder.append("]");
		return builder.toString();
	}
	
	
}
