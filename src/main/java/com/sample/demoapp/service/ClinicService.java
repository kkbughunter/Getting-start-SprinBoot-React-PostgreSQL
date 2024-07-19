package com.sample.demoapp.service;

import com.sample.demoapp.model.Clinic;
import com.sample.demoapp.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService {
    @Autowired
    private ClinicRepository clinicRepository;

    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }

    public List<Clinic> searchClinicsByName(String name) {
        return clinicRepository.findByNameContaining(name);
    }
    
    public Clinic saveClinic(Clinic clinic) {
        return clinicRepository.save(clinic);
    }

    public void deleteClinic(Long id) {
        clinicRepository.deleteById(id);
    }
}
