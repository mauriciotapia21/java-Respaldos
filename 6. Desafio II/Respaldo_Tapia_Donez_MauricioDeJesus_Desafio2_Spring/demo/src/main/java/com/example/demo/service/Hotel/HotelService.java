package com.example.demo.service.Hotel;


import com.example.demo.dto.hotel.PayloadDTO;
import com.example.demo.dto.hotel.ResponseDTO;
import com.example.demo.dto.hotel.ResponseReservationDTO;

import java.util.Date;
/**
 * @author Mauricio tapia */
public interface HotelService
{
    public ResponseDTO allHotels();

    ResponseDTO hotelesAvailable(Date dateFrom, Date dateTo, String destination);
    public ResponseReservationDTO reservaHotel(PayloadDTO payloadDTO, String status);
}
