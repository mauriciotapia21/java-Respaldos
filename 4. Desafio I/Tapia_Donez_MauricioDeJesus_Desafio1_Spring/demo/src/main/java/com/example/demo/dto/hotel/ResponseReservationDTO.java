package com.example.demo.dto.hotel;

import com.example.demo.dto.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResponseReservationDTO
{
   private String userName;
    private Double amount;
    private Double interest;
    private Double total;
    private BookingDTO booking;
    private StatusCode statusCode;
}
