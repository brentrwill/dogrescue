package com.promineotech.dogrescue.services;

import java.lang.reflect.Field;
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
		try {
			Location location = findOrCreateLocation(locationData);
			if (location == null) {
				location = new Location();
				location = (Location) mergeData(locationData, location);
				location = locationDao.save(location);
			} else {
				Location newLocation = new Location();
				newLocation = (Location) mergeData(locationData, location);
				location = locationDao.save(newLocation);
			}
			locationData = (LocationData) mergeData(location, locationData);
		} catch (Exception e) {
			throw new NoSuchElementException("Error processing save/update location", e);
		}
		return locationData;
	}

	public LocationData updateLocationName(String name, Long id) {
		LocationData data = null;
		try {
			locationDao.updateLocationName(name, id);
			data = findLocById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
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
		LocationData data = null;
		try {
			Optional<Location> results = locationDao.findById(locationId);
			Location location = results.orElse(null);
			if (location == null) {
				throw new NoSuchElementException("No Location existed with the Id : " + locationId);
			} else {
				data = new LocationData();
				return (LocationData) mergeData(location, data);
			}
		} catch (Exception e) {
			throw new NoSuchElementException("Error processing location with Id : " + locationId);
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

	public Object mergeData(Object src, Object target) throws Exception {
		Class<?> clazz = src.getClass();
		for (Field srcField : clazz.getDeclaredFields()) {
			srcField.setAccessible(true);
			for (Field targetField : target.getClass().getDeclaredFields()) {
				targetField.setAccessible(true);
				String localName = srcField.getName();
				String remoteName = targetField.getName();
				if (!localName.contains("dog")) {
					if (localName != null && remoteName != null) {
						if (localName.equalsIgnoreCase(remoteName)) {
							Object srcValue = srcField.get(src);
							targetField.set(target, srcValue);
						}
					}
				}
			}
		}
		return target;
	}
}