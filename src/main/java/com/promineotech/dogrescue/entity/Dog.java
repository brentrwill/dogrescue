package com.promineotech.dogrescue.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Dog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dogId;

	@EqualsAndHashCode.Exclude
	private String name;

	@EqualsAndHashCode.Exclude
	private int age;

	@EqualsAndHashCode.Exclude
	private String color;

	// @formatter:off
    /**
     * I looked at this closer and did some debugging on my own.
     * 
     * This is okay to have, basically what we are saying is that any time you ask for a Dog Object/Entity
     * the Location will be populated with an Object of Location.
     * 
     * The @JoinColumn == SELECT * FROM location where LocationId = ?
     * 
     * Because the @JoinColumn in on the Location Object, Spring will map this to the Location Entity and query for the Object.
     * 
     * nullable = false is the same as the below CREATE block
     * 
     * CREATE TABLE dog (
  	 *		...
  	 *		location_id bigint NOT NULL,
  	 *		..
  	 * }
     */
	// @formatter:on
	@JsonIgnore
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "locationId", nullable = false)
	private Location location;

	// @formatter:off
    /**
     * 
     * So if we are looking at the below relationship, the Many Dogs are associated to Many Breeds.
     * @JoinTable specifies the Table that holds the primary keys, fpr example, 
     * 
     * Dog.dog_id and Breed.breed_id both make up the dog_breed Table.
     * 
     * Now since we are coming into this from the Dog, you notice that we have:
     * 
     * 		joinColumns = @JoinColumn(name = "dog_id")
     * 
     * and since we are read the Breed through the Dog Object, then we set:
     * 
     * 		inverseJoinColumns = @JoinColumn(name = "breed_id")
     * 
     * 
     * 
  	 */
	@JsonIgnore
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "dog_breed", joinColumns = @JoinColumn(name = "dog_id"), inverseJoinColumns = @JoinColumn(name = "breed_id"))
	private Set<Breed> breeds = new HashSet<>();

}
