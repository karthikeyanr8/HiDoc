package com.hidoc.consultationtool.Controller;

import com.hidoc.consultationtool.Entity.Doctor;
import com.hidoc.consultationtool.Entity.Patient;
import com.hidoc.consultationtool.Service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/savePatient")
    public Patient savePatient(@RequestBody Patient patient) {
       return patientService.savePatient(patient);
    }

    @GetMapping("/getById/{Id}")
    public Patient fetchPatientById( @PathVariable Long Id) {
        return patientService.findPatientDetailsById(Id);
    }

    @GetMapping("/getByName/{Name}")
    public List<Patient> fetchPatientByName(@PathVariable String Name) {
        return patientService.findPatientDetailsByName(Name);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatientbyId(id);
    }

    @PutMapping("/update/{id}")
    public Patient updatePatient(@PathVariable Long id,
                                 @RequestBody Patient patient) {
        return patientService.updatePatient(id, patient);
    }

}
