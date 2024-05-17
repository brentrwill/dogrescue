package com.promineotech.dogrescue.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import com.promineotech.dogrescue.DogRescueApplication;
import com.promineotech.dogrescue.controller.model.LocationData;


@SpringBootTest(webEnvironment = WebEnvironment.NONE, classes = DogRescueApplication.class)
@ActiveProfiles("test")
@Sql(scripts = {"classpath:schema.sql"})
@SqlConfig(encoding = "utf-8")
public class LocationControllerTest extends RescueServiceTestSupport {

	@Test
	public void testInsertLocation() {
		LocationData request = builderInsertLocation(1);
		LocationData expected = builderInsertLocation(1);
		
		ResponseEntity<LocationData> response = insertLocation(request);
		LocationData actual = response.getBody();
		HttpStatusCode status = response.getStatusCode();
		int statusCode = status.value();
		boolean results = actual.equals(expected);
		
		assertEquals(true, results);
		assertEquals(statusCode, 200);
	}
}
