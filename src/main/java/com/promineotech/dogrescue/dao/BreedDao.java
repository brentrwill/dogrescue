package com.promineotech.dogrescue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineotech.dogrescue.entity.Breed;

public interface BreedDao extends JpaRepository<Breed, Long> {
}
