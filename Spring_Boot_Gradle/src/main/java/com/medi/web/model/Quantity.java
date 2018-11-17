package com.medi.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="QUANTITY_MST_TB")
public class Quantity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int quantityId;
	private int totalQuantity;
	private int availableQuantity;
	private float costPerQuantity;
	
	public float getCostPerQuantity() {
		return costPerQuantity;
	}
	public void setCostPerQuantity(float costPerQuantity) {
		this.costPerQuantity = costPerQuantity;
	}
	public int getQuantityId() {
		return quantityId;
	}
	public void setQuantityId(int quantityId) {
		this.quantityId = quantityId;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

}
