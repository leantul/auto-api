package com.auto.api.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto.api.dao.AdditionalDAO;
import com.auto.api.entities.Additional;

@RestController
@RequestMapping("additional")
public class AdditionalREST {

	@Autowired
	private AdditionalDAO additionalDAO;
	
	@GetMapping
	public ResponseEntity<List<Additional>> getAdditional(){
		List<Additional> listAdditional = additionalDAO.findAll();
		return ResponseEntity.ok(listAdditional);
	}
	
	@RequestMapping(value="{additionalId}")
	public ResponseEntity<Optional<Additional>> getUnitByID(@PathVariable("additionalId") Long additionalId){
		Optional<Additional> additional = additionalDAO.findById(additionalId);
		if(additional.isPresent()) {
			return ResponseEntity.ok(additional);			
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}
