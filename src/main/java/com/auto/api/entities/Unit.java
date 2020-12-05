package com.auto.api.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="unit")
public class Unit {

	@Id
	@Column(name="unitID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long unitID;

	@Column(name="autoID")
	private Long autoID;
	
	@OneToMany(mappedBy="additionalID")
	List<Additional> additionalList;
	
	@Column(name="price", nullable=false, scale = 2)
	private BigDecimal price;
	
	public List<Additional> getAdditionalList() {
		return additionalList;
	}
	
	public void setAdditionalList(List<Additional> additionalList) {
		this.additionalList = additionalList;
	}

	public Long getUnitID() {
		return unitID;
	}
	
	public void setUnitID(Long unitID) {
		this.unitID = unitID;
	}
	
	public Long getAutoID() {
		return autoID;
	}
	
	public void setAutoID(Long autoID) {
		this.autoID = autoID;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
