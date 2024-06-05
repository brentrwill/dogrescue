package com.promineotech.dogrescue.controller.model;

import java.util.HashSet;
import java.util.Set;

import com.promineotech.dogrescue.entity.Dog;
import com.promineotech.dogrescue.entity.Location;

public class LocationData {
	private Long locationId;
	private String businessName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String phone;

	private Set<Dog> dogs = new HashSet<>();

	public LocationData(Long locationId, String businessName, String streetAddress, String city, String state,
			String zip, String phone, Set<Dog> dogs) {
		this.locationId = locationId;
		this.businessName = businessName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.dogs = dogs;
	}

	public LocationData() {
	}

	public LocationData(Long locationId) {
		this.locationId = locationId;
	}

	public LocationData(Location location) {
		this.locationId = location.getLocationId();
		this.businessName = location.getBusinessName();
		this.city = location.getCity();
		this.phone = location.getPhone();
		this.state = location.getState();
		this.zip = location.getZip();
		this.streetAddress = location.getStreetAddress();
		this.dogs = location.getDogs();
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(Set<Dog> dogs) {
		this.dogs = dogs;
	}

	public Location toLocation() {
		Location location = new Location();
		if (this.getBusinessName() != null) {
			location.setBusinessName(this.getBusinessName());
		}

		if (this.getCity() != null) {
			location.setCity(this.getCity());
		}

		if (this.getPhone() != null) {
			location.setPhone(this.getPhone());
		}

		if (this.getState() != null) {
			location.setState(this.getState());
		}
		if (this.getStreetAddress() != null) {
			location.setStreetAddress(this.getStreetAddress());
		}

		if (this.getZip() != null) {
			location.setZip(this.getZip());
		}

		return location;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LocationData that = (LocationData) o;
		if (getLocationId() != that.getLocationId()) {
			return false;
		} else {
			return true;
		}
	}
}
