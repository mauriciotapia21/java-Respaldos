package com.example.demo.dto.vuelo;

import com.example.demo.dto.PaymentMethodDTO;
import com.example.demo.dto.PersonaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import java.util.Date;
import java.util.List;
/**
 * @author Mauricio tapia*/

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * @author Mauricio tapia
 */
public class FlightReservationDTO {


    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateFrom;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateTo;
    private String origin;
    private String destination;
    private String flightNumber;
    @Digits(fraction = 0, integer = 1, message = "La cantidad de personas debe ser un valor numerico.")
    private Integer seats;
    private String seatType;
    List<@Valid PersonaDTO>people;
    @Valid
    private PaymentMethodDTO paymentMethod;
}
