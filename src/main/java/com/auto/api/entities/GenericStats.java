package com.auto.api.entities;

import java.util.Map.Entry;

public class GenericStats {
	
	private String model;
	private Long count;
	private Float percent;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Float getPercent() {
		return percent;
	}
	public void setPercent(Float percent) {
		this.percent = percent;
	}
	
	public static GenericStats setStats(Entry<String, Long> a, Long total) {
		GenericStats unitStats = new GenericStats();
		unitStats.setModel(a.getKey());
		unitStats.setCount(a.getValue());
		unitStats.setPercent(Float.valueOf(a.getValue() * 100 / total));
		return unitStats;
	}
}
