package com.example.demo.service.Hotel;
import com.example.demo.dto.PaymentMethodDTO;
import com.example.demo.dto.StatusCode;
import com.example.demo.dto.hotel.*;
import com.example.demo.entity.Hotel;
import com.example.demo.exceptions.*;
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
   private HotelRepository hotelRepository;

    public HotelServiceImpl(@Autowired HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    /** Método para obtener todos los hoteles disponibles
     * @return una lista de hoteles */
    public ResponseDTO allHotels()
    {
        List<Hotel> hotel = hotelRepository.returnDB();
        ResponseDTO response = new ResponseDTO(hotel);
        if(hotel.size() == 0)
        {
            throw new ListEmptyException("La lista se encuentra vacia");
        }
        return response;
    }

    /** Método para obtener todos los hoteles en un rango de fecha, destino
     * @param dateFrom fecha inicial
     * @param dateTo fecha final
     * @param destination destino
     * @return una lista de hoteles */
    @Override
    public ResponseDTO hotelesAvailable(Date dateFrom, Date dateTo, String destination)
   {
       List<Hotel> lista = hotelRepository.returnDB();

       if(lista.size() == 0)
       {
           throw new ListEmptyException("La lista se encuentra vacia");
       }
       validarFiltroHotel(dateFrom,dateTo,destination);
        List<Hotel> hoteles =lista.stream().filter(hotel ->
                (hotel.getDisponibleDesde().equals(dateFrom) || hotel.getDisponibleDesde().before(dateFrom)) &&
                        (hotel.getDisponibleHasta().equals(dateTo) || hotel.getDisponibleHasta().after(dateTo)) &&
                        hotel.getLugar_Ciudad().equals(destination) && !hotel.isReservado()).collect(Collectors.toList());
        ResponseDTO response = new ResponseDTO(hoteles);
        return response;
    }

    /** Método para realizar una reserva de hotel
     * @param payloadDTO un objeto payloadflight
     * @param status muestra el status de la reserva
     * @return una reserva de vuelo */
    @Override
    public ResponseReservationDTO reservaHotel(PayloadDTO payloadDTO, String status)
    {
        //cantidad de dias que tiene reservado, los obtiene.
        StatusCode statusCode = new StatusCode();
        Date dateFrom = payloadDTO.getBooking().getDateFrom();
        Date dateTo = payloadDTO.getBooking().getDateTo();
        //Validacion
        validarFiltroHotel(payloadDTO.getBooking().getDateFrom(), payloadDTO.getBooking().getDateTo(), payloadDTO.getBooking().getDestination());
        //RestarDias
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

        if(hoteles.size() == 0)
        {
            throw new NotFilterHotelException("El tipo de habitacion que usted ingreso para el hotel no existe y no procedio su registro");
        }

        //ValidarTipoCuarto
        validTypeRoom(payloadDTO.getBooking().getPeopleAmount(),hoteles.stream().map(Hotel::getTipoDeHabitacion).findFirst().get());

        //Validar el tipo de metodo
        int interest = validPaymentMethod(payloadDTO.getBooking().getPaymentMethod().getType(),payloadDTO.getBooking().getPaymentMethod().getDues());
        //precio x noche
        int precioPorNoche =  hoteles.stream().mapToInt(Hotel::getPrecioPorNoche).findFirst().getAsInt();;
        double amount = precioPorNoche * diference;
        double porciento = interest*0.01;
        double total = (amount * porciento) + amount;

        //Status
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

    /** Método para validar algunos campos, me permite mandar unas excepciones
     * @param DateFrom fecha inicial
     * @param DateTo fecha final
     * @param destination destino */
    private void validarFiltroHotel(Date DateFrom,Date DateTo, String destination)
    {
        if(destination == null || destination == "")
        {
            throw new NoDestinationException("El destino elegido no existe");
        }
        List<Hotel> lista = hotelRepository.returnDB();
        List<Hotel> NewList = lista.stream().filter(
                hotel ->(hotel.getLugar_Ciudad().equals(destination)))
                .collect(Collectors.toList());

        if(NewList.size() == 0)
        {
            throw new NoDestinationException("El destino elegido no existe");
        }
        else if(DateFrom.compareTo(DateTo) > 0)
        {
            throw new BadDatePeriod("La fecha de salida debe ser mayor a la de entrada");
        }

    }

    /** Método para validar algunos campos, me permite mandar unas excepciones
     * @param peopleAmount Cantidad de personas
     * @param typeRoom tipo de pago */
    private void validTypeRoom(int peopleAmount, String typeRoom) {
        String message = "La habitacion no coincide con el numero de personas.";
        System.out.println(peopleAmount);
        System.out.println(typeRoom);
        switch(peopleAmount)
        {
            case 1:
                if(!(typeRoom.equals("Single")))
                {
                    throw new BadTypeRoomException("La habitacion no coincide con el numero de personas.");
                }
                break;
            case 2:
                if(!(typeRoom.equals("Doble")))
                {
                    throw new BadTypeRoomException("La habitacion no coincide con el numero de personas.");
                }
                break;
            case 3:
                if(!(typeRoom.equals("Triple")))
                {
                    throw new BadTypeRoomException("La habitacion no coincide con el numero de personas.");
                }
                break;
            case 4:
            case 5:
                if(!(typeRoom.equals("Multiple")))
                {
                    throw new BadTypeRoomException("La habitacion no coincide con el numero de personas.");
                }
                break;
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
