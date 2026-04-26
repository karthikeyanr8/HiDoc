package com.hidoc.consultationtool.Controller;

import com.hidoc.consultationtool.Entity.Doctor;
import com.hidoc.consultationtool.Service.DocService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DocController {

    private final DocService docService;

    public DocController(DocService docService) {
        this.docService = docService;
    }

    @PostMapping("/save")
    public Doctor AddDoctor(@RequestBody Doctor doctor) {
        return docService.saveDoc(doctor);
    }

    @GetMapping("/all")
    public List<Doctor> GetDoctors() {
        return docService.findAllDoc();
    }

    @GetMapping("/{Id}")
    public Doctor GetDocById(@PathVariable Long Id) {
        return docService.findDocById(Id);
    }

    @GetMapping("/designation/{designation}")
    public List<Doctor> GetDocByDesignation(@PathVariable String designation) {
        return docService.findDocByDesignation(designation);
    }

    @PutMapping("/update/{id}")
    public Doctor UpdateDoctorDetails(@PathVariable Long id,
                                      @RequestBody Doctor doctor){
        return docService.UpdateDoc(id, doctor);
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteDoc(@PathVariable Long id)
    {
        docService.deleteDoc(id);
    }
}
