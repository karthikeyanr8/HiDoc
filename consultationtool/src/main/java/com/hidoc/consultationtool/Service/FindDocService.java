package com.hidoc.consultationtool.Service;

import com.hidoc.consultationtool.Entity.Doctor;
import com.hidoc.consultationtool.Repository.DocRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindDocService {

    private final DocRepository docRepository;

    public FindDocService(DocRepository docRepository)
    {
        this.docRepository = docRepository;
    }

    public String findDocById(long Id)
    {
        return docRepository.findById(Id)
                .map(Doctor::getName)
                .orElseThrow(() -> new RuntimeException("Doctor with this ID is not found!"));
    }

    public List<String> findDocByDesignation(String designation)
    {
        return docRepository.findByDesignation(designation);
    }
    public List<String> findAllDoc()
    {
        return docRepository
                .findAll()
                .stream()
                .map(Doctor::getName)
                .toList();
    }
}
