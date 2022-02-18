package com.example.demo.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * @author Mauricio tapia
 */
public class PayloadDTO
{
   private String userName;
   @Valid
   private BookingDTO booking;
}
