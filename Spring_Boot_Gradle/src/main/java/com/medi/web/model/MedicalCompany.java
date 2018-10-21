package com.medi.web.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedicalCompany {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Company_Id;
	private String Company_Name;
	private Date Entry_Date;
	private int Ledger_Number;
	
	public int getCompany_Id() {
		return Company_Id;
	}
	public void setCompany_Id(int company_Id) {
		Company_Id = company_Id;
	}
	public String getCompany_Name() {
		return Company_Name;
	}
	public void setCompany_Name(String company_Name) {
		Company_Name = company_Name;
	}
	public Date getEntry_Date() {
		return Entry_Date;
	}
	public void setEntry_Date(Date entry_Date) {
		Entry_Date = entry_Date;
	}
	public int getLedger_Number() {
		return Ledger_Number;
	}
	public void setLedger_Number(int ledger_Number) {
		Ledger_Number = ledger_Number;
	}

}
