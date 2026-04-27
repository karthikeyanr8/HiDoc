package com.hidoc.consultationtool.Service;

import com.hidoc.consultationtool.Entity.Patient;
import com.hidoc.consultationtool.ExceptionHandling.PatientNotFoundException;
import com.hidoc.consultationtool.Repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Patient> findPatientDetailsByName(String name)
    {
        return patientRepository.findByName(name);
    }

    public Patient findPatientDetailsById(Long id)
    {
        return patientRepository.findById(id)
                .orElseThrow(()->new PatientNotFoundException("Patient with that id not found"));
    }

    public void deletePatientbyId(Long id)
    {
        patientRepository.delete(findPatientDetailsById(id));
    }

    public Patient updatePatient(Long id, Patient patient)
    {
        return patientRepository.findById(id)
                .map(existing ->{
                    existing.setName(patient.getName());
                    existing.setAddress(patient.getAddress());
                    return patientRepository.save(existing);
                })
                .orElseThrow(() -> new PatientNotFoundException("Update Failed"));
    }

}
