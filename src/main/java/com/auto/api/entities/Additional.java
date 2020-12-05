package com.auto.api.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="additional")
public class Additional {
	
	@Id
	@Column(name="additionalID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long additionalID;
	
	@Column(name="name", nullable=false, length=30)
	private String name;
	
	@Column(name="price", nullable=false, scale = 2)
	private BigDecimal price;
	
	public Long getAdditionalID() {
		return additionalID;
	}
	
	public void setAdditionalID(Long additionalID) {
		this.additionalID = additionalID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
