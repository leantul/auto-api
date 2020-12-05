package com.auto.api.rest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto.api.dao.AdditionalDAO;
import com.auto.api.dao.AutoDAO;
import com.auto.api.dao.UnitDAO;
import com.auto.api.entities.Additional;
import com.auto.api.entities.Auto;
import com.auto.api.entities.Unit;

@RestController
@RequestMapping("unit")
public class UnitREST {

	@Autowired
	private UnitDAO unitDAO;
	
	@Autowired
	private AutoDAO autoDAO;
	
	@Autowired
	private AdditionalDAO additionalDAO;
	
	@GetMapping
	public ResponseEntity<List<Unit>> getAuto(){
		List<Unit> listUnit = unitDAO.findAll();
		return ResponseEntity.ok(listUnit);
	}
	
	@RequestMapping(value="{unitId}")
	public ResponseEntity<Optional<Unit>> getUnitByID(@PathVariable("unitId") Long unitId){
		Optional<Unit> unit = unitDAO.findById(unitId);
		if(unit.isPresent()) {
			return ResponseEntity.ok(unit);			
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<BigDecimal> createUnit(@RequestBody Unit unit){
		unit.setPrice(this.calculatePrice(unit));
		Unit newUnit = unitDAO.save(unit);
		return ResponseEntity.ok(newUnit.getPrice());
	}
	
	@DeleteMapping(value="{unitId}")
	public ResponseEntity<Void> deleteUnit(@RequestBody Long unitId){
		unitDAO.deleteById(unitId);
		return ResponseEntity.ok(null);
	}
	
	
	@PutMapping
	public ResponseEntity<BigDecimal> updateUnit(@RequestBody Unit unit){
		Optional<Unit> optionalUnit = unitDAO.findById(unit.getUnitID());
		if(optionalUnit.isPresent()) {
			Unit updateUnit = optionalUnit.get();
			updateUnit.setAutoID(unit.getAutoID());
			updateUnit.setPrice(this.calculatePrice(unit));
			unitDAO.save(updateUnit);
			
			return ResponseEntity.ok(updateUnit.getPrice());			
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	private BigDecimal calculatePrice(Unit unit) {
		// Price without any additional
		Auto auto = autoDAO.findById(unit.getAutoID()).get();
		BigDecimal priceAuto = auto.getPrice();

		// Price with all additional
		BigDecimal priceAdditionals = unit.getAdditionalList().stream()
													.map(Additional::getAdditionalID)
													.map(additionalDAO::findById)
													.map(Optional::get)
													.map(Additional::getPrice)
													.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		return priceAuto.add(priceAdditionals);
	}
}
