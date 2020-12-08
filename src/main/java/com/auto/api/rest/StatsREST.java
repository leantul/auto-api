package com.auto.api.rest;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto.api.dao.AutoDAO;
import com.auto.api.dao.UnitDAO;
import com.auto.api.entities.Additional;
import com.auto.api.entities.Auto;
import com.auto.api.entities.GenericStats;
import com.auto.api.entities.Stats;
import com.auto.api.entities.Unit;

@RestController
@RequestMapping("stats")
public class StatsREST {

	@Autowired
	private UnitDAO unitDAO;
	
	@Autowired
	private AutoDAO autoDAO;
	
	@GetMapping
	public ResponseEntity<Stats> getStats(){
		Stats stats = new Stats();
		
		stats.setCountCars(unitDAO.count());
		stats.setCars(this.getUnitStats());
		stats.setAdditionalStats(this.getAdditionalStats());
		return ResponseEntity.ok(stats);
	}
	
	private List<GenericStats> getAdditionalStats() {
		Long additionalTotalCount = unitDAO.findAll().stream()
											.map(Unit::getAdditionalList)
											.map(List::size)
											.collect(Collectors.summingInt(Integer::intValue))
											.longValue();
														
		Map<String, Long> listAdditionalCount = unitDAO.findAll().stream()
													.map(Unit::getAdditionalList)
													.flatMap(List::stream)
													.collect(Collectors.groupingBy(Additional::getName, Collectors.counting()));
								
		List<GenericStats> listAdditionalStats = listAdditionalCount.entrySet().stream()
													.map(a -> GenericStats.setStats(a, additionalTotalCount))
													.collect(Collectors.toList());	
		
		return listAdditionalStats;
	}

	private List<GenericStats> getUnitStats() {
		Map<String, Long> listCarCount = unitDAO.findAll().stream()
												.map(Unit::getAuto)
												.map(Auto::getAutoId)
												.map(autoDAO::findById)
												.map(Optional::get)
												.collect(Collectors.groupingBy(Auto::getName, Collectors.counting()));
		
		List<GenericStats> listUnitStats = listCarCount.entrySet().stream()
												.map(a -> GenericStats.setStats(a, unitDAO.count()))
												.collect(Collectors.toList());
		
		return listUnitStats;
	}
}
