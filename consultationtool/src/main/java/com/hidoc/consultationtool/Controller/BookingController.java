package com.hidoc.consultationtool.Controller;

import com.hidoc.consultationtool.Entity.Booking;
import com.hidoc.consultationtool.Entity.BookingRequest;
import com.hidoc.consultationtool.Service.BookDocService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
