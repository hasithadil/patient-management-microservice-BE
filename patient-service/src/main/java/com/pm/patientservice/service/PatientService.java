package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<PatientResponseDTO> getAllPatients(){
        List<Patient> patients = patientRepository.findAll();

        List<PatientResponseDTO> patientResponseDTOS = patients.stream().map(PatientMapper::toDTO).toList();
        return patientResponseDTOS;
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        Patient savedPatient = patientRepository.save(PatientMapper.toEntity(patientRequestDTO));
        return PatientMapper.toDTO(savedPatient);
    }

}
