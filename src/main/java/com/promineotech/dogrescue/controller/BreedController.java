package com.promineotech.dogrescue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.dogrescue.controller.model.BreedData;
import com.promineotech.dogrescue.services.BreedService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/breed")
@Slf4j
public class BreedController {
	@Autowired
	private BreedService breedService;
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BreedController.class);

	/**
	 * GET == read, this will read back a Location of the Pet Store
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BreedData> getBreed(@RequestParam(name = "breedId") Long breedId) {
		log.info("Processing GET Request.");
		BreedData data = breedService.findBreedById(breedId);
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
}
