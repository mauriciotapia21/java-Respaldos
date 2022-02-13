package com.example.demo.dto.vuelo;

import com.example.demo.dto.PaymentMethodDTO;
import com.example.demo.dto.PersonaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
/**
 * @author Mauricio tapia*/

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FlightReservationDTO {


    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateFrom;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateTo;
    private String origin;
    private String destination;
    private String flightNumber;
    private Integer seats;
    private String seatType;
    List<PersonaDTO>people;
    private PaymentMethodDTO paymentMethod;
}
