package com.example.demo.dto.hotel;

import com.example.demo.dto.PaymentMethodDTO;
import com.example.demo.dto.PersonaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

/**
 * @author Mauricio tapia*/
@Data
@NoArgsConstructor
@AllArgsConstructor

/** Método para obtener todos los hoteles en un rango de fecha, destino
 * @param dateFrom fecha inicial
 * @param dateTo fecha final
 * @param destination destino
 * @param hotelCode codigo de hotel
 * @param peopleAmount numero de personas
 * @param roomType tipo de habitacion
 * @param people DTO persona
 * @param paymentMethod DTO Payment
 * */

public class BookingDTO {
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateFrom;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateTo;
    private String destination;
    private String hotelCode;
    @Digits(fraction = 0, integer = 1, message = "La cantidad de personas debe ser un valor numerico.")
    @Max(value = 5, message = "El maximo de personas es 5.")
    private Integer peopleAmount;
    private String roomType;
    List<@Valid PersonaDTO>people;
    @Valid
    private PaymentMethodDTO paymentMethod;
}
