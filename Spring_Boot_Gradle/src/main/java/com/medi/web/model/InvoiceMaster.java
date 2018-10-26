package com.medi.web.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Formula;

@Entity(name="INVOICE_MASTER_TB")
public class InvoiceMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int invoiceId;
	private int quantity;
	private String description;
	private int batchId;
	private Date expiryDate;
	private float costPerQuantity;
	private float ratePerQuantity;
	@Formula(" quantity * costPerQuantity")
	private float cost;
	private String customerName;
	private int customerAge;
	
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public float getCost() {
		return cost;
	}
	public float getRatePerQuantity() {
		return ratePerQuantity;
	}
	public void setRatePerQuantity(float ratePerQuantity) {
		this.ratePerQuantity = ratePerQuantity;
	}
	public float getCostPerQuantity() {
		return costPerQuantity;
	}
	public void setCostPerQuantity(float costPerQuantity) {
		this.costPerQuantity = costPerQuantity;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

}
