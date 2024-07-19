package com.sample.demoapp.controller;

import com.sample.demoapp.model.Clinic;
import com.sample.demoapp.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinics")
public class ClinicController {
    @Autowired
    private ClinicService clinicService;

    @GetMapping
    public List<Clinic> getAllClinics() {
        return clinicService.getAllClinics();
    }

    @GetMapping("/name/contains/{name}")
    public List<Clinic> searchClinicsByName(@PathVariable String name) {
        return clinicService.searchClinicsByName(name);
    }

    @PostMapping
    public Clinic addClinic(@RequestBody Clinic clinic) {
        return clinicService.saveClinic(clinic);
    }

    @PutMapping("/{id}")
    public Clinic updateClinic(@PathVariable Long id, @RequestBody Clinic clinic) {
        clinic.setId(id);
        return clinicService.saveClinic(clinic);
    }

    @DeleteMapping("/{id}")
    public void deleteClinic(@PathVariable Long id) {
        clinicService.deleteClinic(id);
    }
}
