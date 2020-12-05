package com.auto.api.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto.api.dao.AutoDAO;
import com.auto.api.entities.Auto;

@RestController
@RequestMapping("auto")
public class AutoREST {

	@Autowired
	private AutoDAO autoDAO;
	
	@GetMapping
	public ResponseEntity<List<Auto>> getAuto(){
		List<Auto> listAuto = autoDAO.findAll();
		return ResponseEntity.ok(listAuto);
	}
	
	@RequestMapping(value="{autoId}")
	public ResponseEntity<Optional<Auto>> getAutoByID(@PathVariable("autoId") Long autoId){
		Optional<Auto> auto = autoDAO.findById(autoId);
		if(auto.isPresent()) {
			return ResponseEntity.ok(auto);			
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}
