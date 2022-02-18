package com.example.demo.service.vuelo;

import com.example.demo.dto.hotel.ResponseDTO;
import com.example.demo.dto.vuelo.PayloadFlightDTO;
import com.example.demo.dto.vuelo.ResponseReservationVueloDTO;
import com.example.demo.dto.vuelo.ResponseVueloDTO;

import java.util.Date;

/**
 * @author Mauricio tapia */

public interface VueloService
{
    public ResponseVueloDTO allVuelos();

    ResponseVueloDTO VuelosAvailable(Date dateFrom, Date dateTo, String origin, String destination);
    public ResponseReservationVueloDTO reservaVuelo(PayloadFlightDTO payloadFlightDTO, String status);
}
