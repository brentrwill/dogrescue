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
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Breed {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long breedId;
	private String name;

	// @formatter:off
    /**
     * 
     * So if we are looking at the below relationship, the Many Breeds are associated to Many Dogs.
     * @JoinTable specifies the Table that holds the primary keys, fpr example, 
     * 
     * Dog.dog_id and Breed.breed_id both make up the dog_breed Table.
     * 
     * Now since we are coming into this from the Breed, you notice that we have:
     * 
     * 		joinColumns = @JoinColumn(name = "breed_id")
     * 
     * and since we are read the Dog through the Breed Object, then we set:
     * 
     * 		inverseJoinColumns = @JoinColumn(name = "dog_id")
     * 
  	 */
	// @formatter:on
	@JsonIgnore
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "dog_breed", joinColumns = @JoinColumn(name = "breed_id"), inverseJoinColumns = @JoinColumn(name = "dog_id"))
	private Set<Dog> dogs = new HashSet<Dog>();
}
