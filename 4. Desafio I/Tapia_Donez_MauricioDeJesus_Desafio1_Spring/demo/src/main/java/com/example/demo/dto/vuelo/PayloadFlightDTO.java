package com.example.demo.dto.vuelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Mauricio tapia*/

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * Esta clase me permite ingresar el userName y asi mismo me manda a llamar la clase flightReservation para reservar el vuelo*/
public class PayloadFlightDTO
{
   private String userName;
   private FlightReservationDTO flightReservation;
}
