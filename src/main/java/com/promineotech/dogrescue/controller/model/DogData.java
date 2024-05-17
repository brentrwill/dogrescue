package com.promineotech.dogrescue.controller.model;

import java.util.HashSet;
import java.util.Set;

import com.promineotech.dogrescue.entity.Breed;
import com.promineotech.dogrescue.entity.Dog;
import com.promineotech.dogrescue.entity.Location;

public class DogData {
	private Long dogId;
	private String name;
	private int age;
	private String color;
	private Location location;
	private Set<Breed> breeds = new HashSet<>();

	public DogData() {
	}

	public DogData(Dog dog) {
		this.dogId = dog.getDogId();
		this.name = dog.getName();
		this.age = dog.getAge();
		this.color = dog.getColor();
		this.location = dog.getLocation();
		this.breeds = dog.getBreeds();
	}

	public Long getDogId() {
		return dogId;
	}

	public void setDogId(Long dogId) {
		this.dogId = dogId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Set<Breed> getBreeds() {
		return breeds;
	}

	public void setBreeds(Set<Breed> breeds) {
		this.breeds = breeds;
	}

}
