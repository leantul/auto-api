package com.auto.api.rest;

import static org.junit.Assert.assertNotNull;

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

import com.auto.api.dao.AutoDAO;
import com.auto.api.dao.UnitDAO;
import com.auto.api.entities.Additional;
import com.auto.api.entities.Auto;
import com.auto.api.entities.Unit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatsRESTTest {

	@InjectMocks
	StatsREST statsRest;
	
	@Mock
	private UnitDAO unitDAO;
	
	@Mock
	private AutoDAO autoDAO;
	
	private Unit unit;
	private Auto auto;
	private Additional firstAdditional;
	private Additional secondAdditional;
	private List<Additional> listAdditional;
	private List<Unit> listUnit;
	
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
		
		listUnit = new ArrayList<Unit>();
		listUnit.add(unit);
	}
	
	@Test
	public void testGetStatsNotNull() {		
		Optional<Auto> optionalAuto = Optional.of(auto);
		Mockito.when(unitDAO.count()).thenReturn(Long.valueOf(10));
		Mockito.when(unitDAO.findAll()).thenReturn(listUnit);
		Mockito.when(autoDAO.findById(Mockito.anyLong())).thenReturn(optionalAuto);
		
		assertNotNull(statsRest.getStats());
	}
	
}
