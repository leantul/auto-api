package com.auto.api.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="unit")
public class Unit {

	@Id
	@Column(name="unitID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long unitID;

	@OneToOne
	@JoinColumn(name="autoID")
	private Auto auto;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="unit_additional",
			   joinColumns = @JoinColumn(name="unitID"),
			   inverseJoinColumns = @JoinColumn(name="additionalID"))
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
	
	public Auto getAuto() {
		return auto;
	}
	
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public void addAdditional(Additional additional) {
		if (additionalList == null) {
			additionalList = new ArrayList<Additional>();
		}
		additionalList.add(additional);
	}
}
