package com.hidoc.consultationtool.Service;

import com.hidoc.consultationtool.Entity.Doctor;
import com.hidoc.consultationtool.Entity.DoctorAvailability;
import com.hidoc.consultationtool.ExceptionHandling.InvalidTimeException;
import com.hidoc.consultationtool.Repository.DoctorAvailabilityRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Service
public class DoctorAvailabilityService {

    private final DoctorAvailabilityRepository doctorAvailabilityRepository;
    private final DocService docService;

    public DoctorAvailabilityService(DoctorAvailabilityRepository doctorAvailabilityRepository, DocService docService){
        this.doctorAvailabilityRepository = doctorAvailabilityRepository;
        this.docService = docService;
    }

    public DoctorAvailability createAvailability(Long doctorId, DayOfWeek day, LocalTime startTime, LocalTime endTime, int slotDuration) {

        if(!startTime.isBefore(endTime)) {
            throw new InvalidTimeException("Endtime should be after StartTime");
        }
        if(slotDuration<=0){
            throw new InvalidTimeException("Slot timing must be greater than 0");
        }

        Doctor doctor = docService.findDocById(doctorId);


        DoctorAvailability doctorAvailability = new DoctorAvailability();
        doctorAvailability.setDoctor(doctor);
        doctorAvailability.setDayOfWeek(day);
        doctorAvailability.setStartTime(startTime);
        doctorAvailability.setEndTime(endTime);
        doctorAvailability.setSlotDuration(slotDuration);
        return doctorAvailabilityRepository.save(doctorAvailability);
    }

}
