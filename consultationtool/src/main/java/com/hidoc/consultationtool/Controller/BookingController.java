package com.hidoc.consultationtool.Controller;

import com.hidoc.consultationtool.Entity.Booking;
import com.hidoc.consultationtool.Entity.BookingRequest;
import com.hidoc.consultationtool.Service.BookDocService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookDocService bookDocService;

    public BookingController(BookDocService bookDocService){
        this.bookDocService = bookDocService;
    }

    @PostMapping("/book")
    public Booking doctorBooking(@RequestBody BookingRequest bookingRequest)
    {
        return bookDocService.bookDoctor(bookingRequest.getDoctorId(), bookingRequest.getPatientId(), bookingRequest.getTimeFrame());
    }

    @GetMapping("/patient/{id}")
    public List<Booking> getBookingFromPatId(@PathVariable Long id)
    {
        return bookDocService.searchBookingByPatientId(id);
    }
    @GetMapping("/doctor/{id}")
    public List<Booking> getBookingFromDocId(@PathVariable Long id)
    {
        return bookDocService.searchBookingByDoctorId(id);
    }

}
