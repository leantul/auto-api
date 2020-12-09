package com.auto.api.rest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.auto.api.dao.AdditionalDAO;
import com.auto.api.dao.AutoDAO;
import com.auto.api.dao.UnitDAO;
import com.auto.api.entities.Additional;
import com.auto.api.entities.Auto;
import com.auto.api.entities.Unit;

@RunWith(SpringRunner.class)
@SpringBootTest
class UnitRESTTest {

	@InjectMocks
	UnitREST unitRest;

	@Mock
	private UnitDAO unitDAO;
	
	@Mock
	private AutoDAO autoDAO;
	
	@Mock
	private AdditionalDAO additionalDAO;
	
	private Unit unit;
	private Auto auto;
	private Additional firstAdditional;
	private Additional secondAdditional;
	private List<Additional> listAdditional;
	
	@BeforeEach
	public void setUp() {
		firstAdditional = new Additional();
		firstAdditional.setAdditionalID(Long.valueOf(1));
		firstAdditional.setName("Techo corredizo");
		firstAdditional.setPrice(BigDecimal.valueOf(12000));
		
		secondAdditional = new Additional();
		secondAdditional.setAdditionalID(Long.valueOf(4));
		secondAdditional.setName("Airbag");
		secondAdditional.setPrice(BigDecimal.valueOf(7000));
		
		listAdditional = new ArrayList<Additional>();
		listAdditional.add(firstAdditional);
		listAdditional.add(secondAdditional);
		
		auto = new Auto();
		auto.setAutoId(Long.valueOf(1));
		auto.setName("Sedán");
		auto.setPrice(BigDecimal.valueOf(230000));
		
		unit = new Unit();
		unit.setUnitID(Long.valueOf(1));
		unit.setAuto(auto);
		unit.setAdditionalList(listAdditional);
	}
	
	@Test
	public void testGetUnitsNotNull() {
		List<Unit> listUnit = new ArrayList<Unit>();
		Mockito.when(unitDAO.findAll()).thenReturn(listUnit);
		assertNotNull(unitRest.getUnits());
	}
	
	@Test
	public void testGetUnitsSizeOne() {
		List<Unit> listUnit = new ArrayList<Unit>();
		listUnit.add(unit);
		Mockito.when(unitDAO.findAll()).thenReturn(listUnit);
		assertEquals(1, unitRest.getUnits().getBody().size());
	}
	
	@Test
	public void testGetUnitByID() {
		Optional<Unit> optionalUnit = Optional.of(unit);
		Mockito.when(unitDAO.findById(Mockito.anyLong())).thenReturn(optionalUnit);
		assertEquals(unit, unitRest.getUnitByID(Mockito.anyLong()).getBody());
	}
	
	@Test
	public void testGetUnitByIDIsNull() {
		Optional<Unit> optionalUnit = Optional.of(unit);
		Mockito.when(unitDAO.findById(Long.valueOf(15))).thenReturn(optionalUnit);
		assertNull(unitRest.getUnitByID(Mockito.anyLong()).getBody());
	}
	
	@Test
	public void testGetAdditionalByUnitID() {
		Optional<Unit> optionalUnit = Optional.of(unit);
		Mockito.when(unitDAO.findById(Mockito.anyLong())).thenReturn(optionalUnit);
		assertEquals(listAdditional, unitRest.getAdditionalByUnitID(Mockito.anyLong()).getBody());
	}
	
	@Test
	public void testGetAdditionalListByUnitIdIsNull() {
		Optional<Unit> optionalUnit = Optional.of(unit);
		Mockito.when(unitDAO.findById(Long.valueOf(15))).thenReturn(optionalUnit);
		assertNull(unitRest.getAdditionalByUnitID(Mockito.anyLong()).getBody());
	}
	
	@Test
	public void testGetAdditionalListByUnitIdSize() {
		Optional<Unit> optionalUnit = Optional.of(unit);
		Mockito.when(unitDAO.findById(Mockito.anyLong())).thenReturn(optionalUnit);
		Unit unitTest = unitRest.getUnitByID(Mockito.anyLong()).getBody();
		assertEquals(2, unitTest.getAdditionalList().size());
	}
	
	@Test
	public void testCreateUnit() {
		Optional<Unit> optionalUnit = Optional.of(unit);
		Optional<Auto> optionalAuto = Optional.of(auto);
		Optional<Additional> optionalAdditional = Optional.of(firstAdditional);
		
		Mockito.when(unitDAO.findById(Mockito.anyLong())).thenReturn(optionalUnit);
		Mockito.when(autoDAO.findById(Mockito.anyLong())).thenReturn(optionalAuto);
		Mockito.when(additionalDAO.findById(Mockito.anyLong())).thenReturn(optionalAdditional);
		Mockito.when(unitDAO.save(Mockito.any())).thenReturn(unit);
		
		BigDecimal unitPrice =  unitRest.createUnit(unit).getBody();
		
		assertEquals(1, unitPrice.compareTo(BigDecimal.ZERO));
	}
	
	@Test
	public void testUpdateUnitByid() {
		Optional<Unit> optionalUnit = Optional.of(unit);
		Optional<Auto> optionalAuto = Optional.of(auto);
		Optional<Additional> optionalAdditional = Optional.of(firstAdditional);
		
		Mockito.when(unitDAO.findById(Mockito.anyLong())).thenReturn(optionalUnit);
		Mockito.when(autoDAO.findById(Mockito.anyLong())).thenReturn(optionalAuto);
		Mockito.when(additionalDAO.findById(Mockito.anyLong())).thenReturn(optionalAdditional);
		Mockito.when(unitDAO.save(Mockito.any())).thenReturn(unit);
		
		BigDecimal unitPrice =  unitRest.updateUnit(unit).getBody();
		
		assertEquals(1, unitPrice.compareTo(BigDecimal.ZERO));
	}
	
	@Test
	public void testUpdateUnitByIdNotFound() {
		Unit unitTest = new Unit();	
		
		Optional<Unit> optionalUnit = Optional.of(unitTest);
		Optional<Auto> optionalAuto = Optional.of(auto);
		Optional<Additional> optionalAdditional = Optional.of(firstAdditional);
		
		Mockito.when(unitDAO.findById(Mockito.anyLong())).thenReturn(optionalUnit);
		Mockito.when(autoDAO.findById(Mockito.anyLong())).thenReturn(optionalAuto);
		Mockito.when(additionalDAO.findById(Mockito.anyLong())).thenReturn(optionalAdditional);
		Mockito.when(unitDAO.save(Mockito.any())).thenReturn(unitTest);
		
		assertNull(unitRest.updateUnit(unitTest).getBody());
	}
	
	@Test
	public void testDeleteById() {
        unitRest.deleteUnit(Mockito.anyLong());
        Mockito.verify(unitDAO, times(1)).deleteById(Mockito.anyLong());
	}
}
