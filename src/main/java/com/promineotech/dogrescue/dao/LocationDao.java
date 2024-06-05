package com.promineotech.dogrescue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.dogrescue.entity.Location;

public interface LocationDao extends JpaRepository<Location, Long> {
	@Transactional
	@Modifying
	@Query("update Location l set l.businessName = :name where l.locationId = :id")
	int updateLocationName(@Param("name") String name, @Param("id") Long id);
}