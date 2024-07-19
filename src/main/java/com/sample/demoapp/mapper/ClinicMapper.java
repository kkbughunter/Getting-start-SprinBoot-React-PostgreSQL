package com.sample.demoapp.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.demoapp.dto.ClinicDTO;
import com.sample.demoapp.model.Clinic;

@Component
public class ClinicMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ClinicMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ClinicDTO toDTO(Clinic clinic){
        return modelMapper.map(clinic, ClinicDTO.class);
    }

    public Clinic toEntity(ClinicDTO clinicDTO){
        return modelMapper.map(clinicDTO, Clinic.class);
    }
}
