package com.hidoc.consultationtool.Repository;

import com.hidoc.consultationtool.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Patient, Long> {

}
