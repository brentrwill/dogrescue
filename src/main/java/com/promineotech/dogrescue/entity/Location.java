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
import lombok.Data;

@Entity
@Data
public class Location {

	public Location(Long locationId) {
		this.locationId = locationId;
	}

	public Location() {
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
     * to and pulling Dogs, then this will simply use the primary of Location in the 
     * Dog Table.
  	 */
	// @formatter:on
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Dog> dogs = new HashSet<>();
}
