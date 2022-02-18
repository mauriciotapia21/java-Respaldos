package com.example.demo.service.vuelo;

import com.example.demo.dto.StatusCode;
import com.example.demo.dto.vuelo.PayloadFlightDTO;
import com.example.demo.dto.vuelo.ResponseReservationVueloDTO;
import com.example.demo.dto.vuelo.ResponseVueloDTO;
import com.example.demo.entity.Vuelo;
import com.example.demo.exceptions.*;
import com.example.demo.repository.Vuelo.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;



@Service
public class VueloServiceImpl implements VueloService {
    @Autowired
    VueloRepository vueloRepository;

    /** Método para obtener todos los Vuelos disponibles
     * @return una lista de Vuelos */
    public ResponseVueloDTO allVuelos() {
        List<Vuelo> vuelo = vueloRepository.returnVuelos();
        ResponseVueloDTO response = new ResponseVueloDTO(vuelo);
        if(vuelo.size() == 0)
        {
            throw new ListEmptyException("La lista se encuentra vacia");
        }
        return response;
    }
    /** Método para obtener todos los Vuelos en un rango de fecha, punto de partida y destino
     * @param dateFrom fecha inicial
     * @param dateTo fecha final
     * @param destination destino
     * @param origin origen
     * @return una lista de Vuelos */
    @Override
    public ResponseVueloDTO VuelosAvailable(Date dateFrom, Date dateTo, String origin, String destination) {
        List<Vuelo> lista = vueloRepository.returnVuelos();
        if(lista.size() == 0)
        {
            throw new ListEmptyException("La lista se encuentra vacia");
        }
        validarFiltroVuelo(dateFrom,dateTo,origin,destination);

        List<Vuelo> flightss = vueloRepository.returnVuelos().stream().filter(hotel ->
                (hotel.getDateFrom().equals(dateFrom) || hotel.getDateFrom().before(dateFrom)) &&
                        (hotel.getDateTo().equals(dateTo) || hotel.getDateTo().after(dateTo)) &&
                        hotel.getOrigin().equals(origin) &&
                        hotel.getDestination().equals(destination)).collect(Collectors.toList());

        ResponseVueloDTO response = new ResponseVueloDTO(flightss);
        return response;
    }

    /** Método para realizar una reserva de vuelo
     * @param payloadFlightDTO un objeto payloadflight
     * @param status muestra el status de la reserva
     * @return una reserva de vuelo */
    @Override
    public ResponseReservationVueloDTO reservaVuelo(PayloadFlightDTO payloadFlightDTO, String status) {
        StatusCode responseStatusCode = new StatusCode();

        validarFiltroVuelo(payloadFlightDTO.getFlightReservation().getDateFrom(),payloadFlightDTO.getFlightReservation().getDateTo(),payloadFlightDTO.getFlightReservation().getOrigin(),payloadFlightDTO.getFlightReservation().getDestination());

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

        int interest = validPaymentMethod(payloadFlightDTO.getFlightReservation().getPaymentMethod().getType(),payloadFlightDTO.getFlightReservation().getPaymentMethod().getDues());
        //precio x noche
        double amount = precioPorVuelo * payloadFlightDTO.getFlightReservation().getSeats();
        double porciento = interest*0.01;
        double total = (amount * porciento) + amount;

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

    /** Método para validar algunos campos, me permite mandar unas excepciones
     * @param DateFrom fecha inicial
     * @param DateTo fecha final
     * @param destination destino
     * @param origin origen */
   private void validarFiltroVuelo(Date DateFrom,Date DateTo, String origin , String destination)
    {
      if(origin == null || origin == "")
        {
            throw new NoDestinationException("El origen elegido no existe");
        }
         if(destination == null || destination == "")
        {
            throw new NoDestinationException("El destino elegido no existe");
        }
        List<Vuelo> lista = vueloRepository.returnVuelos();
        List<Vuelo> NewList = lista.stream().filter(
                        vuelo ->(vuelo.getOrigin().equals(origin)) &&
                                (vuelo.getDestination().equals((destination)))).collect(Collectors.toList());

        if(NewList.size() == 0)
        {
            throw new NoDestinationException("El destino u origen ingresado no existe");
        }
        if(DateFrom.compareTo(DateTo) > 0)
        {
            throw new BadDatePeriod("La fecha de salida debe ser mayor a la de entrada");
        }
    }

    /** Método para validar el tipo de pago que se va realizar aplicando ciertas excepciones
     * @param type tipo de pago
     * @param dues meses que se haran los cargos de interes
     * @return el interes de la aplicado al metodo de pago CREDIT */
    private int validPaymentMethod(String type, int dues) {
        int interest = 0;
        if(Objects.equals(type,"DEBIT"))
        {
            switch (dues) {
                case 1:
                    interest = 0;
                    break;
                default: throw new PayMentCardException("El Tipo de pago que hiciste fue con DEBITO por favor poner 1 en su couta de pago");
            }
        }
        else if(Objects.equals(type, "CREDIT")){
            switch(dues) {
                case 1:
                case 2:
                case 3:
                    interest = 5;
                    break;
                case 4:
                case 5:
                case 6:
                    interest = 10;
                    break;
                case 10:
                case 11:
                case 12:
                    interest = 20;
                    break;
                case 16:
                case 17:
                case 18:
                    interest = 30;
                    break;
                default: throw new InterestNotValidException("El tipo de tiempo a interes no aplica, favor de ingresar uno de las siguientes opciones [1,2,3,4,5,6,10,11,12,16,17,18]");
            }
        }else {
            throw new NoPaymentException("El pago solo se puede realizar por tarjeta");
        }
        return interest;
    }
}
