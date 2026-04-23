package com.hidoc.consultationtool.Service;

import com.hidoc.consultationtool.Entity.Doctor;
import com.hidoc.consultationtool.Repository.DocRepository;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class FindDocService {

    private final DocRepository docRepository;

    public FindDocService(DocRepository docRepository)
    {
        this.docRepository = docRepository;
    }

    public Doctor findDocById(long Id)
    {
        return docRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Doctor with this ID is not found!"));
    }

    public List<Doctor> findDocByDesignation(String designation)
    {
        return docRepository.findByDesignation(designation);
    }
    public List<Doctor> findAllDoc()
    {
        return docRepository
                .findAll()
                .stream()
                .toList();
    }

    public Doctor saveDoc(Doctor doctor)
    {
        return docRepository.save(doctor);
    }
}
