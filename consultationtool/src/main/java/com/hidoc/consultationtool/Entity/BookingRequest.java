package com.hidoc.consultationtool.Entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {
    public Long doctorId;
    public Long patientId;
    public String timeFrame;
}
