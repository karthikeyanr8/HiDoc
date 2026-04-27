package com.hidoc.consultationtool.Service;

import com.hidoc.consultationtool.Entity.Doctor;
import com.hidoc.consultationtool.ExceptionHandling.DoctorNotFoundException;
import com.hidoc.consultationtool.Repository.DocRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocService {

    private final DocRepository docRepository;

    public DocService(DocRepository docRepository) {
        this.docRepository = docRepository;
    }

    public Doctor findDocById(long Id) {
        return docRepository.findById(Id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor with this ID is not found!"));
    }

    public List<Doctor> findDocByDesignation(String designation) {
        return docRepository.findByDesignation(designation);
    }

    public List<Doctor> findAllDoc() {
        return docRepository
                .findAll()
                .stream()
                .toList();
    }

    public Doctor saveDoc(Doctor doctor) {
        return docRepository.save(doctor);
    }

    public Doctor UpdateDoc(Long id,Doctor doctor) {
        return docRepository.findById(id)
                .map(existing -> {
                    existing.setName(doctor.getName());
                    existing.setAge(doctor.getAge());
                    existing.setDesignation(doctor.getDesignation());
                    existing.setSpecialization(doctor.getSpecialization());
                    existing.setStatus(doctor.getStatus());
                    return docRepository.save(existing);
                })
                .orElseThrow(() -> new DoctorNotFoundException("Update Doctor Details Failed"));
    }

    public void deleteDoc(Long id){
        docRepository.delete(findDocById(id));
    }
}
