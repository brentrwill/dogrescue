package com.promineotech.dogrescue.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.dogrescue.controller.model.DogData;
import com.promineotech.dogrescue.dao.DogDao;
import com.promineotech.dogrescue.entity.Dog;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DogService {
	@Autowired
	private DogDao dogDao;
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DogService.class);

	public void deleteDog(Long dogId) {
		try {
			dogDao.deleteById(dogId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred trying to delete dog with Id : " + dogId);
		}
	}

	public DogData saveDog(DogData dogData) {
		Dog dog = findOrCreateDog(dogData);
		if (dog == null) {
			dog = copyDogDataToDog(dogData);
			dog = dogDao.save(dog);
		} else {
			dog = copyDogDataToDog(dogData);
			dog = dogDao.save(dog);
		}
		dogData = copyDogToDogData(dog);
		return dogData;
	}

	private Dog findOrCreateDog(DogData dogData) {
		Dog dog = null;
		try {
			dog = findById(dogData.getDogId());
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return dog;
	}

	private Dog findById(Long dogId) {
		Optional<Dog> results = dogDao.findById(dogId);
		Dog dog = results.orElse(null);
		if (dog == null) {
			throw new NoSuchElementException("No Dog existed with the Id : " + dogId);
		} else {
			return dog;
		}
	}

	public DogData findDogById(long dogId) {
		Optional<Dog> results = dogDao.findById(dogId);
		Dog dog = results.orElse(null);
		if (dog == null) {
			throw new NoSuchElementException("No Dog existed with the Id : " + dogId);
		} else {
			return copyDogToDogData(dog);
		}
	}

	private Dog copyDogDataToDog(DogData data) {
		Dog dog = new Dog();
		if (data.getAge() >= 0) {
			dog.setAge(data.getAge());
		}

		if (data.getBreeds() != null) {
			dog.setBreeds(data.getBreeds());
		}

		if (data.getColor() != null) {
			dog.setColor(data.getColor());
		}

		if (data.getDogId() != null) {
			dog.setDogId(data.getDogId());
		}
		if (data.getLocation() != null) {
			dog.setLocation(data.getLocation());
		}
		return dog;
	}

	private DogData copyDogToDogData(Dog data) {
		DogData dog = new DogData(data);
		return dog;
	}
}
