package com.promineotech.dogrescue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineotech.dogrescue.entity.Location;

public interface LocationDao extends JpaRepository<Location, Long> {
}