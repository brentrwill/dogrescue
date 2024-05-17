package com.promineotech.dogrescue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.promineotech.dogrescue.controller.model.LocationData;
import com.promineotech.dogrescue.entity.Location;

public class RescueServiceTestSupport {

	LocationData insertAddress1 = new LocationData(1l, "All About Pets", "1234 West Central St.", "San Francisco",
			"California", "94601", "415-888-7777", null);
	LocationData insertAddress2 = new LocationData(2l, "All About Pets", "9898 South West St.", "San Francisco",
			"California", "94601", "415-111-2222", null);
	@Autowired
	private LocationController locationController;

	protected LocationData builderInsertLocation(int which) {
		return which == 1 ? insertAddress1 : insertAddress2;
	}

	protected ResponseEntity<LocationData> insertLocation(LocationData locationData) {
		Location location = locationData.toLocation();
		LocationData clone = new LocationData(location);

		clone.setLocationId(0l);
		ResponseEntity<LocationData> data = locationController.createLocation(clone);
		return data;
	}

}
