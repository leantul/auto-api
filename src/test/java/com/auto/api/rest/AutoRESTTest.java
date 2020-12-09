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

import com.auto.api.dao.AutoDAO;
import com.auto.api.entities.Auto;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoRESTTest {

	@InjectMocks
	AutoREST autoRest;
	
	@Mock
	private AutoDAO autoDAO;
	
	private Auto firstAuto;
	private Auto secondAuto;
	List<Auto> listAuto;
	
	@BeforeEach
	public void setUp() {
		firstAuto = new Auto();
		firstAuto.setAutoId(Long.valueOf(1));
		firstAuto.setName("Sedán");
		firstAuto.setPrice(BigDecimal.valueOf(230000));
		
		secondAuto = new Auto();
		secondAuto.setAutoId(Long.valueOf(1));
		secondAuto.setName("Familiar");
		secondAuto.setPrice(BigDecimal.valueOf(245000));
		
		listAuto = new ArrayList<Auto>();
		listAuto.add(firstAuto);
		listAuto.add(secondAuto);
	}
	
	@Test
	public void testGetAutosNotNull() {
		Mockito.when(autoDAO.findAll()).thenReturn(listAuto);
		assertNotNull(autoRest.getAuto());
	}
	
	@Test
	public void testGetAutoSizeOne() {
		Mockito.when(autoDAO.findAll()).thenReturn(listAuto);
		assertEquals(2, autoRest.getAuto().getBody().size());
	}
	
	@Test
	public void testGetAutoByID() {
		Optional<Auto> optionalAuto = Optional.of(firstAuto);
		Mockito.when(autoDAO.findById(Mockito.anyLong())).thenReturn(optionalAuto);
		assertEquals(firstAuto, autoRest.getAutoByID(Mockito.anyLong()).getBody().get());
	}
	
	@Test
	public void testGetAutoByIDIsNull() {
		Optional<Auto> optionalAuto = Optional.of(firstAuto);
		Mockito.when(autoDAO.findById(Long.valueOf(15))).thenReturn(optionalAuto);
		assertNull(autoRest.getAutoByID(Mockito.anyLong()).getBody());
	}
	
}
