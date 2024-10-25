package com.promineotech.dogrescue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.promineotech.dogrescue.controller.model.LocationData;

public class RescueServiceTestSupport {

	LocationData insertAddress1 = new LocationData("All About Pets", "1234 West Central St.", "San Francisco",
			"California", "94601", "415-888-7777", null);
	LocationData insertAddress2 = new LocationData("All About Pets", "9898 South West St.", "San Francisco",
			"California", "94601", "415-111-2222", null);
	@Autowired
	private LocationController locationController;

	protected LocationData builderInsertLocation(int which) {
		return which == 1 ? insertAddress1 : insertAddress2;
	}

	protected ResponseEntity<LocationData> insertLocation(LocationData locationData) {
		ResponseEntity<LocationData> data = locationController.createLocation(locationData);
		return data;
	}

	protected ResponseEntity<LocationData> getLocation(Long locationId) {
		ResponseEntity<LocationData> data = locationController.getLocation(locationId);
		return data;
	}

	protected ResponseEntity<List<LocationData>> getAllLocations() {
		ResponseEntity<List<LocationData>> data = locationController.getAllLocations();
		return data;
	}
}
