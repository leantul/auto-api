package com.auto.api.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stats {

	@JsonProperty(value = "count_car")
	private Long countCars;
	private List<GenericStats> additional;
	private List<GenericStats> cars;
	
	public Long getCountCars() {
		return countCars;
	}

	public void setCountCars(Long countCars) {
		this.countCars = countCars;
	}

	public List<GenericStats> getAdditionalStats() {
		return additional;
	}
	
	public void setAdditionalStats(List<GenericStats> additionalStats) {
		this.additional = additionalStats;
	}
	
	public List<GenericStats> getCars() {
		return cars;
	}
	
	public void setCars(List<GenericStats> cars) {
		this.cars = cars;
	}
}
