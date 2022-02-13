package com.example.demo.service.Hotel;
import com.example.demo.dto.StatusCode;
import com.example.demo.dto.hotel.*;
import com.example.demo.entity.Hotel;
import com.example.demo.repository.Hotel.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;



@Service
public class HotelServiceImpl implements HotelService
{
    @Autowired
    HotelRepository hotelRepository;
    public ResponseDTO allHotels()
    {
        List<Hotel> hotel = hotelRepository.returnDB();
        ResponseDTO response = new ResponseDTO(hotel);
        return response;
    }

    @Override
    public ResponseDTO hotelesAvailable(Date dateFrom, Date dateTo, String destination){
        List<Hotel> lista = hotelRepository.returnDB();
        List<Hotel> hoteles =lista.stream().filter(hotel ->
                (hotel.getDisponibleDesde().equals(dateFrom) || hotel.getDisponibleDesde().before(dateFrom)) &&
                        (hotel.getDisponibleHasta().equals(dateTo) || hotel.getDisponibleHasta().after(dateTo)) &&
                        hotel.getLugar_Ciudad().equals(destination) && !hotel.isReservado()).collect(Collectors.toList());
        ResponseDTO response = new ResponseDTO(hoteles);
        return response;
    }


    @Override
    public ResponseReservationDTO reservaHotel(PayloadDTO payloadDTO, String status)
    {
        //cantidad de dias que tiene reservado, los obtiene.
        StatusCode statusCode = new StatusCode();
        Date dateFrom = payloadDTO.getBooking().getDateFrom();
        Date dateTo = payloadDTO.getBooking().getDateTo();
        long restDias = dateTo.getTime() - dateFrom.getTime();
        TimeUnit tiempo = TimeUnit.DAYS;
        long diference = tiempo.convert(restDias,TimeUnit.MILLISECONDS);

        //hace el filtrado...
        List<Hotel> hoteles = hotelRepository.returnDB().stream()
                .filter(hotel ->
                  (hotel.getLugar_Ciudad().equals(payloadDTO.getBooking().getDestination())
                          && hotel.getCodigoHotel().equals(payloadDTO.getBooking().getHotelCode()))
                          && (hotel.getTipoDeHabitacion().equals(payloadDTO.getBooking().getRoomType()))
                          && !hotel.isReservado())
                .collect(Collectors.toList());

        int totalPrecioXnoche = hoteles.stream().mapToInt(Hotel::getPrecioPorNoche).findFirst().getAsInt();
        double amount = totalPrecioXnoche * diference;

        double interest, total= 0.0;
        if (Objects.equals(payloadDTO.getBooking().getPaymentMethod().getType(), "CREDIT"))
        {
            interest = 5.5;
            total = amount + (amount * 0.055);

        }
        else
        {
            interest = 0;
            total = amount;
        }


        String[] parts = status.split(" ");
        String codeString = parts[0];
        int codeInt = Integer.parseInt(codeString);
        if(codeInt == 200){
            statusCode.setCode(codeInt);
            statusCode.setMessage("El proceso terminó satisfactoriamente");
        }

        System.out.println(" ---------> : "+ statusCode);
        ResponseReservationDTO responseReservationDTO = new ResponseReservationDTO(payloadDTO.getUserName(),amount,interest,total,payloadDTO.getBooking(),statusCode);
        return responseReservationDTO;
    }
}
