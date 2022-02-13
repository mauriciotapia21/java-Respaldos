package com.example.demo.dto.vuelo;
import com.example.demo.dto.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mauricio tapia*/

@Data
@NoArgsConstructor
@AllArgsConstructor

/** esta clase me permite hacer el monto en total en que va pagar por el vuelo la persona*/
public class ResponseReservationVueloDTO
{
   private String userName;
    private Double amount;
    private Double interest;
    private Double total;
    private FlightReservationDTO flightReservation;
    private StatusCode statusCode;
}
