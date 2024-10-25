package com.promineotech.dogrescue.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.SqlConfig;

import com.promineotech.dogrescue.DogRescueApplication;
import com.promineotech.dogrescue.controller.model.LocationData;

@SpringBootTest(webEnvironment = WebEnvironment.NONE, classes = DogRescueApplication.class)
@ActiveProfiles("test")
@SqlConfig(encoding = "utf-8")
public class LocationControllerTest extends RescueServiceTestSupport {

	// @Test
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

	// @Test
	public void testGetLocation() {
		LocationData request = builderInsertLocation(10);
		ResponseEntity<LocationData> response = insertLocation(request);
		LocationData location = response.getBody();

		response = getLocation(location.getLocationId());
		LocationData actual = response.getBody();
		HttpStatusCode status = response.getStatusCode();
		int statusCode = status.value();
		boolean results = actual.equals(request);

		assertEquals(true, results);
		assertEquals(statusCode, 200);
	}

	@Test
	public void testGetAllLocations() {
		LocationData loc1 = builderInsertLocation(1);
		LocationData loc2 = builderInsertLocation(2);
		insertLocation(loc1);
		insertLocation(loc2);

		ResponseEntity<List<LocationData>> data = getAllLocations();
		List<LocationData> locations = data.getBody();
		HttpStatusCode status = data.getStatusCode();
		int statusCode = status.value();

		assertEquals(locations.size(), 3);
		assertEquals(statusCode, 200);
	}
}
