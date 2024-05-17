package com.promineotech.dogrescue.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.dogrescue.controller.model.BreedData;
import com.promineotech.dogrescue.dao.BreedDao;
import com.promineotech.dogrescue.entity.Breed;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BreedService {

	@Autowired
	private BreedDao breedDao;
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BreedService.class);

	public BreedData saveBreed(BreedData breedData) {
		Breed breed = findOrCreateBreed(breedData);
		if (breed == null) {
			breed = copyBreedDataToBreed(breedData);
			breed = breedDao.save(breed);
		} else {
			breed = copyBreedDataToBreed(breedData);
			breed = breedDao.save(breed);
		}
		breedData = copyBreedToBreedData(breed);
		return breedData;
	}

	private Breed findOrCreateBreed(BreedData breedData) {
		Breed breed = null;
		try {
			breed = findById(breedData.getBreedId());
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return breed;
	}

	public BreedData findBreedById(long breedId) {
		Optional<Breed> results = breedDao.findById(breedId);
		Breed breed = results.orElse(null);
		if (breed == null) {
			throw new NoSuchElementException("No Breed existed with the Id : " + breedId);
		} else {
			return copyBreedToBreedData(breed);
		}
	}

	private Breed findById(long breedId) {
		Optional<Breed> results = breedDao.findById(breedId);
		Breed breed = results.orElse(null);
		if (breed == null) {
			throw new NoSuchElementException("No Breed existed with the Id : " + breedId);
		} else {
			return breed;
		}
	}

	private Breed copyBreedDataToBreed(BreedData data) {
		Breed breed = new Breed();

		if (data.getName() != null) {
			breed.setName(data.getName());
		}

		if (data.getBreedId() != null) {
			breed.setBreedId(data.getBreedId());
		}

		if (data.getDogs() != null) {
			breed.setDogs(data.getDogs());
		}

		return breed;
	}

	private BreedData copyBreedToBreedData(Breed data) {
		BreedData breed = new BreedData(data);
		return breed;
	}
}
