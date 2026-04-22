package com.hidoc.consultationtool.Repository;

import com.hidoc.consultationtool.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocRepository extends JpaRepository<Doctor, Long> {
    List<String> findByDesignation(String designation);
}
