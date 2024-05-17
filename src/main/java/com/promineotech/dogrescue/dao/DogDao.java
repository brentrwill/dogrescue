package com.promineotech.dogrescue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineotech.dogrescue.entity.Dog;

public interface DogDao extends JpaRepository<Dog, Long> {
}