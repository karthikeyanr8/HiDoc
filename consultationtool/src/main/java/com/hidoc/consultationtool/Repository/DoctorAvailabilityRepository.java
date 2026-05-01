package com.hidoc.consultationtool.Repository;

import com.hidoc.consultationtool.Entity.DoctorAvailability;
import com.hidoc.consultationtool.Entity.DoctorSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorAvailabilityRepository extends JpaRepository<DoctorAvailability, Long> {

}
