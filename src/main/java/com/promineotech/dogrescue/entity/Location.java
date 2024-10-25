package com.promineotech.dogrescue.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder(toBuilder = true)
public class Location {

	public Location(Long locationId) {
		this.locationId = locationId;
	}

	public Location() {
	}

	public Location(Long locationId, String businessName, String streetAddress, String city, String state, String zip,
			String phone, Set<Dog> dogs) {
		this.locationId = locationId;
		this.businessName = businessName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.dogs = dogs;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long locationId;
	private String businessName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String phone;

	// @formatter:off
    /**
     * 
     * This is simple One to Many and since we are reading from the Location
     * to and pulling Dogs, then this will simply use the primary key of Location in the 
     * Dog Table.
  	 */
	// @formatter:on
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Dog> dogs = new HashSet<>();
}
