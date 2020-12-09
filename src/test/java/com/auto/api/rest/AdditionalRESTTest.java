package com.auto.api.rest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
import com.auto.api.entities.Additional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdditionalRESTTest {
	
	@InjectMocks
	AdditionalREST additionalRest;
	
	@Mock
	private AdditionalDAO additionalDAO;
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
	}
	
	@Test
	public void testGetAdditionalNotNull() {
		Mockito.when(additionalDAO.findAll()).thenReturn(listAdditional);
		assertNotNull(additionalRest.getAdditional());
	}
	
	@Test
	public void testGetAdditionalSizeOne() {
		Mockito.when(additionalDAO.findAll()).thenReturn(listAdditional);
		assertEquals(2, additionalRest.getAdditional().getBody().size());
	}
	
	@Test
	public void testGetUnitByID() {
		Optional<Additional> optionalAdditional = Optional.of(firstAdditional);
		Mockito.when(additionalDAO.findById(Mockito.anyLong())).thenReturn(optionalAdditional);
		assertEquals(optionalAdditional, additionalRest.getAdditionalByID(Mockito.anyLong()).getBody());
	}
	
	@Test
	public void testGetAdditionalByIdIsNull() {
		Optional<Additional> optionalAdditional = Optional.of(firstAdditional);
		Mockito.when(additionalDAO.findById(Long.valueOf(15))).thenReturn(optionalAdditional);
		assertNull(additionalRest.getAdditionalByID(Mockito.anyLong()).getBody());
	}
}
