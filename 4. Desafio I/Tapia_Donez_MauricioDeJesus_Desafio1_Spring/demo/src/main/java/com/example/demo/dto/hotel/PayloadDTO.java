package com.example.demo.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PayloadDTO
{
   private String userName;
   private BookingDTO booking;
}
