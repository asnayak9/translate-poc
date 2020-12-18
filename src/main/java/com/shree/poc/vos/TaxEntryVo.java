package com.shree.poc.vos;

import java.util.ArrayList;
import java.util.List;

import com.shree.poc.entities.TaxAccount;
import com.shree.poc.entities.Taxbook;

public class TaxEntryVo {

	private long taxbookId;

	private Integer sno;

	private Integer demandNo;
	
	private Integer doorNo;
	
	private String houseType;
	
	private String name;
	
	private String fhName;
	
	private Integer height;
	
	private Integer length;
	
	private Integer total;

	private List<TaxAccountVo> taxAccount;
	
	public TaxEntryVo() {}

	public TaxEntryVo(Taxbook taxBook) {
		this.sno = taxBook.getSno();
		this.demandNo = taxBook.getDemandNo();
		this.doorNo = taxBook.getDoorNo();
		this.fhName = taxBook.getFhName();
		this.height = taxBook.getHeight();
		this.houseType = taxBook.getHouseType();
		this.length = taxBook.getLength();
		this.name = taxBook.getName();
		this.taxbookId = taxBook.getTaxbookId();
		
		this.taxAccount = new ArrayList<>();
		for(TaxAccount ta : taxBook.getTaxAccount()) {
			this.taxAccount.add(new TaxAccountVo(ta));
		}
	}

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

	public List<TaxAccountVo> getTaxAccount() {
		return taxAccount;
	}

	public void setTaxAccount(List<TaxAccountVo> taxAccount) {
		this.taxAccount = taxAccount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaxEntryVo [taxbookId=");
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
