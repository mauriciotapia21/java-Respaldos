package com.example.demo.controller;
import com.example.demo.dto.hotel.PayloadDTO;
import com.example.demo.dto.hotel.ResponseDTO;
import com.example.demo.dto.hotel.ResponseReservationDTO;
import com.example.demo.dto.vuelo.PayloadFlightDTO;
import com.example.demo.dto.vuelo.ResponseReservationVueloDTO;
import com.example.demo.dto.vuelo.ResponseVueloDTO;
import com.example.demo.service.Hotel.HotelService;
import com.example.demo.service.vuelo.VueloService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class AgenciaRestController
{
    @Autowired
    HotelService hotelService;
    @Autowired
    VueloService vueloService;

    @GetMapping("/api/v1/hotels")
    public ResponseEntity<ResponseDTO> returnAllHotels()
    {
        return new ResponseEntity<ResponseDTO>(hotelService.allHotels(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/flights")
    public ResponseEntity<ResponseVueloDTO> returnAllVuelos()
    {
        return new ResponseEntity<ResponseVueloDTO>(vueloService.allVuelos(), HttpStatus.OK);
    }


    @GetMapping(path = "/api/v1/hotels", params = {"dateFrom", "dateTo", "destination"})
    public ResponseEntity<ResponseDTO> returnsHotelsAvailable(
            @RequestParam()
            @DateTimeFormat(pattern="dd/MM/yyyy")
                    Date dateFrom,
            @RequestParam()
            @DateTimeFormat(pattern="dd/MM/yyyy")
                    Date dateTo,
            @RequestParam()
                    String destination

    ){
        return new ResponseEntity<>(hotelService.hotelesAvailable(dateFrom ,dateTo , destination),HttpStatus.OK);
    }
    
    @GetMapping(path = "/api/v1/flights", params = {"dateFrom", "dateTo", "origin" ,"destination"})
    public ResponseEntity<ResponseVueloDTO> returnsVuelosAvailable(
            @RequestParam()
            @DateTimeFormat(pattern="dd/MM/yyyy")
                    Date dateFrom,
            @RequestParam()
            @DateTimeFormat(pattern="dd/MM/yyyy")
                    Date dateTo,
            @RequestParam()
                    String origin,
            @RequestParam()
                    String destination

    ){
        return new ResponseEntity<>(vueloService.VuelosAvailable(dateFrom ,dateTo , origin ,destination),HttpStatus.OK);
    }
    @PostMapping ("/api/v1/booking")
    public ResponseEntity<ResponseReservationDTO>reservacion(@RequestBody PayloadDTO payloadDTO)
    {
        return new ResponseEntity<ResponseReservationDTO>(hotelService.reservaHotel(payloadDTO, String.valueOf(HttpStatus.OK)),HttpStatus.OK);
    }
    @PostMapping ("/api/v1/flight-reservation")
    public ResponseEntity<ResponseReservationVueloDTO>reservacionVuelo(@RequestBody PayloadFlightDTO payloadFlightDTO)
    {
        return new ResponseEntity<ResponseReservationVueloDTO>(vueloService.reservaVuelo(payloadFlightDTO, String.valueOf(HttpStatus.OK)),HttpStatus.OK);
    }
}
