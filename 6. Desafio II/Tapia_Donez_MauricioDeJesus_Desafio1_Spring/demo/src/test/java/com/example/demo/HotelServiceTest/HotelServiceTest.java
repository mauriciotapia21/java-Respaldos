package com.example.demo.HotelServiceTest;

import com.example.demo.dto.PaymentMethodDTO;
import com.example.demo.dto.PersonaDTO;
import com.example.demo.dto.hotel.BookingDTO;
import com.example.demo.dto.hotel.PayloadDTO;
import com.example.demo.dto.hotel.ResponseDTO;
import com.example.demo.dto.hotel.ResponseReservationDTO;
import com.example.demo.entity.Hotel;
import com.example.demo.exceptions.*;
import com.example.demo.repository.Hotel.HotelRepository;
import com.example.demo.service.Hotel.HotelServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.*;

/**
 * @author Mauricio tapia
 */

@ExtendWith(MockitoExtension.class)
public class HotelServiceTest {

    @Mock
    HotelRepository hotelRepository;

    @InjectMocks
    HotelServiceImpl hotelService;


    @Test
    @DisplayName("US 0001 encuentra datos")
    void testGetAllHotels() {
        //Arrange
        ResponseDTO responseDTO;
        //Act
        when(hotelRepository.returnDB()).thenReturn(hotelList());
        responseDTO = hotelService.allHotels();
        System.out.println(responseDTO);
        //Assert
        Assertions.assertTrue(!responseDTO.getHotelesResgistrados().isEmpty());
    }

    @Test
    @DisplayName("US 0001 SN mock")
    void testGetNotAllHotels() {
        //Act
        ListEmptyException listEmptyException = Assertions.assertThrows(ListEmptyException.class, () -> hotelService.allHotels());
        // Assert
        Assertions.assertEquals("La lista se encuentra vacia", listEmptyException.getMessage());
    }

    @Test
    @DisplayName("US 0001: CN Mock")
    void testGetNotAllHotelsCnMock() {
        //Arrange
        List<Hotel> hotels = new ArrayList<>();

        //Act
        when(hotelRepository.returnDB()).thenReturn(hotels);
        //Se captura el error y se ingresa en una variable de tipo ListEmptyException
        ListEmptyException listEmptyException = Assertions.assertThrows(ListEmptyException.class, () -> hotelService.allHotels());

        // Assert
        Assertions.assertEquals("La lista se encuentra vacia", listEmptyException.getMessage());
    }

    //___________________________US 0002___________________________________________________
    @Test
    @DisplayName("US 0002: Lista de hoteles disponibles")
    void testGetAllHotelsAvailable() {
        //Arrange
        ResponseDTO responseDTO;

        //Act
        when(hotelRepository.returnDB()).thenReturn(hotelList());
        responseDTO = hotelService.hotelesAvailable(
                new Date(2022, 02, 15),
                new Date(2022, 02, 20),
                "Puerto Iguazú");

        System.out.println(responseDTO);
        // Assert
        Assertions.assertTrue(!responseDTO.getHotelesResgistrados().isEmpty());
    }

    @Test
    @DisplayName("US 0002 Error en las fechas")
    void testGetAllHotelsIsAvailable() {
        //Arrange
        String message = "La fecha de salida debe ser mayor a la de entrada";
        //Act
        when(hotelRepository.returnDB()).thenReturn(hotelList());
        //Assert
        BadDatePeriod badDatePeriod = Assertions.assertThrows(BadDatePeriod.class, () -> hotelService.hotelesAvailable(
                new Date(2022, 02, 20),
                new Date(2022, 02, 15),
                "Buenos Aires"));

        Assertions.assertEquals(message, badDatePeriod.getMessage());
    }

    @Test
    @DisplayName("US 0002 destino no existe")
    void testGetAllHotelsIsAvailable1() {
        //Act
        String message = "El destino elegido no existe";
        //Arrange
        when(hotelRepository.returnDB()).thenReturn(hotelList());
        //Assert
        NoDestinationException noDestinationException = Assertions.assertThrows(NoDestinationException.class, () -> hotelService.hotelesAvailable(
                new Date(2022, 02, 20),
                new Date(2022, 02, 15),
                "Buenas"));

        Assertions.assertEquals(message, noDestinationException.getMessage());
    }

    @Test
    @DisplayName("US 0002 la lista se encuentra vacia")
    void testGetAllHotelsIsAvailable2() {
        //Arrange
        String message = "La lista se encuentra vacia";
        List<Hotel> hotel = new ArrayList<>();
        //Act
        when(hotelRepository.returnDB()).thenReturn(hotel);
        //Assert
        ListEmptyException listEmptyException = Assertions.assertThrows(ListEmptyException.class, () -> hotelService.hotelesAvailable(
                new Date(2022, 02, 20),
                new Date(2022, 02, 15),
                "Buenas"));

        Assertions.assertEquals(message, listEmptyException.getMessage());
    }
    //-----------------------------US 0003------------------------------------------------------------

    @Test
    @DisplayName("US 0003: Reserva de hotel")
    void testPostBooking()
    {
        //Arrange
        ResponseReservationDTO response;

        //Act
        when(hotelRepository.returnDB()).thenReturn(hotelList());
        response = hotelService.reservaHotel(payloadHotelDTO(), String.valueOf(HttpStatus.OK));

        System.out.println(response);

        // Assert
        Assertions.assertEquals(200, response.getStatusCode().getCode());
    }

    @Test
    @DisplayName("US 0003: El destino no existe.")
    void testNotPostBooking()
    {

        //Arrange
        PayloadDTO payloadHotelDTO = payloadHotelDTO();
        payloadHotelDTO.getBooking().setDestination("Mexico");

        //Act
        when(hotelRepository.returnDB()).thenReturn(hotelList());
        NoDestinationException notDestinationException =
                Assertions.assertThrows(NoDestinationException.class,
                        ()-> {
                            hotelService.reservaHotel(
                                    payloadHotelDTO,
                                    String.valueOf(HttpStatus.OK)
                            );
                        }
                );

        // Assert
        Assertions.assertEquals("El destino elegido no existe", notDestinationException.getMessage());
    }


    @Test
    @DisplayName("US 0003: fechade entrada mayor.")
    void testNotPostBooking1()
    {
        //Arrange
        String message = "La fecha de salida debe ser mayor a la de entrada";
        PayloadDTO payloadHotelDTO = payloadHotelDTO();
        payloadHotelDTO.getBooking().setDateFrom(new Date(2022, 02,23));

        //Act
        when(hotelRepository.returnDB()).thenReturn(hotelList());

        BadDatePeriod badDateException =
                Assertions.assertThrows(BadDatePeriod.class,
                        ()-> hotelService.reservaHotel(
                                payloadHotelDTO,
                                String.valueOf(HttpStatus.OK)
                        )
                );

        // Assert
        Assertions.assertEquals(message, badDateException.getMessage());
    }


    @Test
    @DisplayName("US 0003: fecha de salida menor.")
    void testNotPostBooking2()
    {
        //Arrange
        String message = "La fecha de salida debe ser mayor a la de entrada";
        PayloadDTO payloadHotelDTO = payloadHotelDTO();
        payloadHotelDTO.getBooking().setDateTo(new Date(2022, 02,10));

        //Act
        when(hotelRepository.returnDB()).thenReturn(hotelList());

        BadDatePeriod badDateException =
                Assertions.assertThrows(BadDatePeriod.class,
                        ()-> hotelService.reservaHotel(
                                payloadHotelDTO,
                                String.valueOf(HttpStatus.OK)
                        )
                );

        // Assert
        Assertions.assertEquals(message, badDateException.getMessage());
    }

    @Test
    @DisplayName("US 0003: Hotel no encontrado")
    void testNotPostBooking3()
    {
        //Arrange
        String message = "El tipo de habitacion que usted ingreso para el hotel no existe y no procedio su registro";
        PayloadDTO payloadHotelDTO = payloadHotelDTO();
        payloadHotelDTO.getBooking().setRoomType("Triple");
        payloadHotelDTO.getBooking().setPeopleAmount(3);

        //Act
        when(hotelRepository.returnDB()).thenReturn(hotelList());

        NotFilterHotelException listEmpty =
                Assertions.assertThrows(NotFilterHotelException.class,
                        ()-> hotelService.reservaHotel(
                                payloadHotelDTO,
                                String.valueOf(HttpStatus.OK)
                        )
                );

        // Assert
        Assertions.assertEquals(message, listEmpty.getMessage());
    }

    @Test
    @DisplayName("US 000: Habitacion incompatible")
    void testNotPostBooking4()
    {
        //Arrange
        String message = "La habitacion no coincide con el numero de personas.";
        PayloadDTO payloadHotelDTO = payloadHotelDTO();
        payloadHotelDTO.getBooking().setRoomType("Doble");
        payloadHotelDTO.getBooking().setPeopleAmount(3);

        //Act
        when(hotelRepository.returnDB()).thenReturn(hotelList());

        BadTypeRoomException badTypeRoom =
                Assertions.assertThrows(BadTypeRoomException.class,
                        ()-> hotelService.reservaHotel(
                                payloadHotelDTO,
                                String.valueOf(HttpStatus.OK)
                        )
                );

        // Assert
        Assertions.assertEquals(message, badTypeRoom.getMessage());
    }

    @Test
    @DisplayName("US 0003: Metodo de pago incompatible")
    void testNotPostBooking5()
    {
        //Arrange
        String message = "El Tipo de pago que hiciste fue con DEBITO por favor poner 1 en su couta de pago";
        PayloadDTO payloadHotelDTO = payloadHotelDTO();
        payloadHotelDTO.getBooking().getPaymentMethod().setType("DEBIT");
        payloadHotelDTO.getBooking().getPaymentMethod().setDues(6);

        //Act
        when(hotelRepository.returnDB()).thenReturn(hotelList());

        PayMentCardException payMentCardException =
                Assertions.assertThrows(PayMentCardException.class,
                        ()-> hotelService.reservaHotel(
                                payloadHotelDTO,
                                String.valueOf(HttpStatus.OK)
                        )
                );

        // Assert
        Assertions.assertEquals(message, payMentCardException.getMessage());
    }

    @Test
    @DisplayName("US 0003: Metodo de pago interes-tarjeta")
    void testNotPostBooking6()
    {
        //Arrange
        String message = "El tipo de tiempo a interes no aplica, favor de ingresar uno de las siguientes opciones [1,2,3,4,5,6,10,11,12,16,17,18]";
        PayloadDTO payloadHotelDTO = payloadHotelDTO();
        payloadHotelDTO.getBooking().getPaymentMethod().setType("CREDIT");
        payloadHotelDTO.getBooking().getPaymentMethod().setDues(19);

        //Act
        when(hotelRepository.returnDB()).thenReturn(hotelList());

        InterestNotValidException interestNotValidException =
                Assertions.assertThrows(InterestNotValidException.class,
                        ()-> hotelService.reservaHotel(
                                payloadHotelDTO,
                                String.valueOf(HttpStatus.OK)
                        )
                );

        // Assert
        Assertions.assertEquals(message, interestNotValidException.getMessage());
    }

    @Test
    @DisplayName("US 0003: Metodo de pago No valido")
    void testNotPostBooking7()
    {
        //Arrange
        String message = "El pago solo se puede realizar por tarjeta";
        PayloadDTO payloadHotelDTO = payloadHotelDTO();
        payloadHotelDTO.getBooking().getPaymentMethod().setType("AGUACATE");
        payloadHotelDTO.getBooking().getPaymentMethod().setDues(1);

        //Act
        when(hotelRepository.returnDB()).thenReturn(hotelList());

        NoPaymentException cashInvalidException =
                Assertions.assertThrows(NoPaymentException.class,
                        ()-> hotelService.reservaHotel(
                                payloadHotelDTO,
                                String.valueOf(HttpStatus.OK)
                        )
                );

        // Assert
        Assertions.assertEquals(message, cashInvalidException.getMessage());
    }



        private Hotel hotel1(){
        return new Hotel("HS-0001", "Hotel Sun", "Puerto Iguazú", "Doble", 3033, new Date(2022, 2, 10), new Date(2022, 3, 19), false);
    }

    private Hotel hotel2(){
        return new Hotel("HV-0001", "Hotel Verano", "Buenos Aires", "Triple", 5700, new Date(2022,2,12), new Date(2022, 4, 17), false);
    }

    private List<Hotel> hotelList(){
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(hotel1());
        hotelList.add(hotel2());
        return hotelList;
    }
    private PayloadDTO payloadHotelDTO(){

        PaymentMethodDTO paymentMethodDTO = new PaymentMethodDTO(
                "CREDIT",
                "1233-3434-2321-1233",
                3
        );

        ArrayList<PersonaDTO> peopleDTO = new ArrayList<>();
        peopleDTO.add(new PersonaDTO(
                1233,
                "Mauricio",
                "Tapia",
                new Date(2000, 07,15),
                "mau@gmail.com"
        ));

        peopleDTO.add(new PersonaDTO(
                12331,
                "johana",
                "Tapia",
                new Date(1996, 02,17),
                "johana@gmail.com"
        ));


        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setDateFrom(new Date(2022, 02,15));
        bookingDTO.setDateTo(new Date(2022, 02,20));
        bookingDTO.setDestination("Puerto Iguazú");
        bookingDTO.setHotelCode("HS-0001");
        bookingDTO.setPeopleAmount(2);
        bookingDTO.setRoomType("Doble");
        bookingDTO.setPeople(peopleDTO);
        bookingDTO.setPaymentMethod(paymentMethodDTO);

        PayloadDTO payloadHotelDTO = new PayloadDTO();
        payloadHotelDTO.setUserName("Mau");
        payloadHotelDTO.setBooking(bookingDTO);
        return payloadHotelDTO;
    }

}
