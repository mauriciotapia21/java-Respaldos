package com.example.demo.service.vuelo;

import com.example.demo.dto.StatusCode;
import com.example.demo.dto.vuelo.PayloadFlightDTO;
import com.example.demo.dto.vuelo.ResponseReservationVueloDTO;
import com.example.demo.dto.vuelo.ResponseVueloDTO;
import com.example.demo.entity.Vuelo;
import com.example.demo.repository.Vuelo.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;



@Service
public class VueloServiceImpl implements VueloService {
    @Autowired
    VueloRepository vueloRepository;

    public ResponseVueloDTO allVuelos() {
        List<Vuelo> vuelo = vueloRepository.returnVuelos();
        ResponseVueloDTO response = new ResponseVueloDTO(vuelo);
        return response;
    }

    @Override
    public ResponseVueloDTO VuelosAvailable(Date dateFrom, Date dateTo, String origin, String destination) {
        List<Vuelo> lista = vueloRepository.returnVuelos();
        List<Vuelo> flights = lista.stream().filter(flight ->
                (flight.getDateFrom().equals(dateFrom) || flight.getDateFrom().before(dateFrom)) &&
                        (flight.getDateTo().equals(dateTo) || flight.getDateTo().after(dateTo)) &&
                        flight.getDestination().equals(destination) &&
                        flight.getOrigin().equals(origin)).collect(Collectors.toList());
        ResponseVueloDTO response = new ResponseVueloDTO(flights);
        return response;
    }

    @Override
    public ResponseReservationVueloDTO reservaVuelo(PayloadFlightDTO payloadFlightDTO, String status) {
        StatusCode responseStatusCode = new StatusCode();
        //filtrado
        int precioPorVuelo = vueloRepository.returnVuelos().stream().
                filter(
                        flight ->
                                (flight.getOrigin().equals(payloadFlightDTO.getFlightReservation().getOrigin()) &&
                                        flight.getDestination().equals(payloadFlightDTO.getFlightReservation().getDestination())) &&
                                        (flight.getSeatType().equals(payloadFlightDTO.getFlightReservation().getSeatType())) &&
                                        (flight.getFlightNumber().equals(payloadFlightDTO.getFlightReservation().getFlightNumber())))
                .mapToInt(Vuelo::getAmount).
                sum();
        System.out.println("-----> " + precioPorVuelo);
        //precio x noche
        double amount = precioPorVuelo * payloadFlightDTO.getFlightReservation().getSeats();
        double interest, total;
        if (Objects.equals(payloadFlightDTO.getFlightReservation().getPaymentMethod().getType(), "CREDITO")) {
            interest = 5.5;
            total = (amount * .055) + amount;
        } else {
            interest = 0.0;
            total = amount;
        }


        //return
        String[] parts = status.split(" ");
        String codeString = parts[0];
        int codeInt = Integer.parseInt(codeString);
        if (codeInt == 200) {
            responseStatusCode.setCode(codeInt);
            responseStatusCode.setMessage("El proceso terminó satisfactoriamente");
        }

        ResponseReservationVueloDTO response = new ResponseReservationVueloDTO(payloadFlightDTO.getUserName(), amount, interest, total, payloadFlightDTO.getFlightReservation(), responseStatusCode);
        return response;
    }
}
