package com.hidoc.consultationtool.Controller;

import com.hidoc.consultationtool.Entity.Doctor;
import com.hidoc.consultationtool.Entity.Patient;
import com.hidoc.consultationtool.Repository.DocRepository;
import com.hidoc.consultationtool.Service.FindDocService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DocController {

    private final FindDocService findDocService;

    public DocController(FindDocService findDocService) {
        this.findDocService = findDocService;
    }

    @PostMapping("/save")
    public Doctor AddDoctor(@RequestBody Doctor doctor) {
        return findDocService.saveDoc(doctor);
    }

    @GetMapping("/all")
    public List<Doctor> GetDoctors() {
        return findDocService.findAllDoc();
    }

    @GetMapping("/{Id}")
    public Doctor GetDocById(@PathVariable Long Id) {
        return findDocService.findDocById(Id);
    }

    @GetMapping("/designation/{designation}")
    public List<Doctor> GetDocByDesignation(@PathVariable String designation) {
        return findDocService.findDocByDesignation(designation);
    }

    @PutMapping("/update/{id}")
    public Doctor UpdateDoctorDetails(@PathVariable Long id,
                                      @RequestBody Doctor doctor){
        return findDocService.UpdateDoc(id, doctor);
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteDoc(@PathVariable Long id)
    {
        findDocService.deleteDoc(id);
    }
}
