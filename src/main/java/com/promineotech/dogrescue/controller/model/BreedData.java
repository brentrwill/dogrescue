package com.promineotech.dogrescue.controller.model;

import java.util.HashSet;
import java.util.Set;

import com.promineotech.dogrescue.entity.Breed;
import com.promineotech.dogrescue.entity.Dog;

public class BreedData {
	private Long breedId;
	private String name;
	private Set<Dog> dogs = new HashSet<Dog>();

	public BreedData(Breed breed) {
		this.name = breed.getName();
		this.breedId = breed.getBreedId();
		this.dogs = breed.getDogs();
	}

	public Long getBreedId() {
		return breedId;
	}

	public void setBreedId(Long breedId) {
		this.breedId = breedId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(Set<Dog> dogs) {
		this.dogs = dogs;
	}
}
