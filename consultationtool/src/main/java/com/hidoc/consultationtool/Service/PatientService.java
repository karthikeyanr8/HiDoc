package com.hidoc.consultationtool.Service;

import com.hidoc.consultationtool.Entity.Patient;
import com.hidoc.consultationtool.Repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository)
    {
        this.patientRepository = patientRepository;
    }

    public int findTotalPatient()
    {
        return patientRepository.findAll()
                .stream()
                .map(Patient::getName)
                .toArray().length;
    }

    public Patient savePatient(Patient patient)
    {
        return patientRepository.save(patient);
    }

    public Patient findPatientDetailsByName(String name)
    {
        return patientRepository.findByName(name);
    }

    public Patient findPatientDetailsById(Long Id)
    {
        return patientRepository.findById(Id)
                .orElseThrow(()->new RuntimeException("Patient with that id not found"));
    }

}
