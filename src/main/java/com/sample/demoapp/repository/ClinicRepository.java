package com.sample.demoapp.repository;

import com.sample.demoapp.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
    @Query("SELECT c FROM Clinic c WHERE c.name LIKE %:name%")
    List<Clinic> findByNameContaining(@Param("name") String name);
}
