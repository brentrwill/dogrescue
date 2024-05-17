package com.promineotech.dogrescue.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.dogrescue.controller.model.LocationData;
import com.promineotech.dogrescue.dao.LocationDao;
import com.promineotech.dogrescue.entity.Location;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LocationService {

	@Autowired
	private LocationDao locationDao;
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LocationService.class);

	public LocationData saveLocation(LocationData locationData) {
		Location location = findOrCreateLocation(locationData);
		if (location == null) {
			location = copyToLocation(locationData);
			location = locationDao.save(location);
		} else {
			location = copyToLocation(locationData);
			location = locationDao.save(location);
		}
		locationData = copyToLocationData(location);
		return locationData;
	}

	private Location findOrCreateLocation(LocationData locatoinData) {
		Location location = null;
		try {
			location = findLocationById(locatoinData.getLocationId());
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return location;
	}
	
	public LocationData findLocById(long locationId) {
		Optional<Location> results = locationDao.findById(locationId);
		Location location = results.orElse(null);
		if (location == null) {
			throw new NoSuchElementException("No Location existed with the Id : " + locationId);
		} else {
			return copyToLocationData(location);
		}
	}
	
	private Location findLocationById(long locationId) {
		Optional<Location> results = locationDao.findById(locationId);
		Location location = results.orElse(null);
		if (location == null) {
			throw new NoSuchElementException("No Location existed with the Id : " + locationId);
		} else {
			return location;
		}
	}

	private Location copyToLocation(LocationData data) {
		Location location = new Location();
		if (data.getBusinessName() != null) {
			location.setBusinessName(data.getBusinessName());
		}

		if (data.getCity() != null) {
			location.setCity(data.getCity());
		}

		if (data.getPhone() != null) {
			location.setPhone(data.getPhone());
		}
		
		if (data.getState() != null) {
			location.setState(data.getState());
		}
		if (data.getStreetAddress() != null) {
			location.setStreetAddress(data.getStreetAddress());
		}

		if (data.getZip() != null) {
			location.setZip(data.getZip());
		}

		return location;
	}

	private LocationData copyToLocationData(Location data) {
		LocationData location = new LocationData(data);
		return location;
	}
}