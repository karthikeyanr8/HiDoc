package com.hidoc.consultationtool.Repository;

import com.hidoc.consultationtool.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByDoctorId(Long doctor_id);
    List<Booking> findByPatientId(Long patient_id);
}
