package com.hidoc.consultationtool.Repository;

import com.hidoc.consultationtool.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocRepository extends JpaRepository<Doctor, Long> {
}
