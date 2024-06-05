package com.promineotech.dogrescue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.dogrescue.controller.model.DogData;
import com.promineotech.dogrescue.services.DogService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/dog")
@Slf4j
public class DogController {
	@Autowired
	private DogService dogService;
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DogController.class);

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DogData> createDog(@RequestBody DogData clone) {
		log.info("Processing GET Request.");
		DogData d = dogService.saveDog(clone);
		return ResponseEntity.status(HttpStatus.OK).body(d);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DogData> getDog(@RequestParam(name = "dogId") Long dogId) {
		log.info("Processing GET Request.");
		DogData data = dogService.findDogById(dogId);
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}

	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteDog(@RequestParam(name = "dogId") Long dogId) {
		log.info("Processing Delete Request.");
		dogService.deleteDog(dogId);
		return "Ok";
	}

}
