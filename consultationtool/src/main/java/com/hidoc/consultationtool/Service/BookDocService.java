package com.hidoc.consultationtool.Service;

import com.hidoc.consultationtool.Entity.Booking;
import com.hidoc.consultationtool.Entity.Doctor;
import com.hidoc.consultationtool.Entity.DoctorStatus;
import com.hidoc.consultationtool.Entity.Patient;
import com.hidoc.consultationtool.ExceptionHandling.BookingNotFoundException;
import com.hidoc.consultationtool.ExceptionHandling.DoctorNotFoundException;
import com.hidoc.consultationtool.Repository.BookingRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDocService {

    private final DocService docService;
    private final PatientService patientService;
    private final BookingRepository bookingRepository;
    public BookDocService(BookingRepository bookingRepository, DocService docService, PatientService patientService) {
        this.docService = docService;
        this.patientService = patientService;
        this.bookingRepository = bookingRepository;
    }

    public Booking bookDoctor(Long doc_id, Long pat_id, String timeFrame) {
        Doctor doctor = docService.findDocById(doc_id);

        if(doctor.getStatus() != DoctorStatus.AVAILABLE){
            throw new DoctorNotFoundException("Doctor is not Available");
        }

        Patient patient = patientService.findPatientDetailsById(pat_id);
        Booking booking = new Booking();
        booking.setDoctor(doctor);
        booking.setPatient(patient);
        booking.setTimeFrame(timeFrame);
        return bookingRepository.save(booking);
    }

    public Booking fetchBookingById(Long bookingId)
    {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with this bookingId"));
    }

    public List<Booking> searchBookingByPatientId(Long pat_id)
    {
        return bookingRepository.findByPatientId(pat_id);
    }
    public List<Booking> searchBookingByDoctorId(Long doc_id)
    {
        return bookingRepository.findByDoctorId(doc_id);
    }
}
