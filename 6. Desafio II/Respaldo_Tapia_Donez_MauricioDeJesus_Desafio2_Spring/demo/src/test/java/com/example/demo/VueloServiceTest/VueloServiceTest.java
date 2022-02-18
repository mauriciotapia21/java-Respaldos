package com.example.demo.VueloServiceTest;
import com.example.demo.dto.PaymentMethodDTO;
import com.example.demo.dto.PersonaDTO;
import com.example.demo.dto.vuelo.FlightReservationDTO;
import com.example.demo.dto.vuelo.PayloadFlightDTO;
import com.example.demo.dto.vuelo.ResponseReservationVueloDTO;
import com.example.demo.dto.vuelo.ResponseVueloDTO;
import com.example.demo.entity.Vuelo;
import com.example.demo.exceptions.*;
import com.example.demo.repository.Vuelo.VueloRepository;
import com.example.demo.service.vuelo.VueloServiceImpl;
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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VueloServiceTest {
    @Mock
    VueloRepository vueloRepository;
    @InjectMocks
    VueloServiceImpl vueloService;

    @Test
    @DisplayName("US 0001 encuentra datos")
    void testGetAllFlights()
    {
        //Arrange
        ResponseVueloDTO responseVueloDTO;
        //Act
        when(vueloRepository.returnVuelos()).thenReturn(flightList());
        responseVueloDTO = vueloService.allVuelos();
        System.out.println(responseVueloDTO);
        //Assert
        assertTrue(!responseVueloDTO.getVuelosRegistrados().isEmpty());
    }
    @Test
    @DisplayName("US 0001: CN Mock")
    void testGetNotAllFlightCnMock() {
        //Arrange
        List<Vuelo> vuelos = new ArrayList<>();

        //Act
        when(vueloRepository.returnVuelos()).thenReturn(vuelos);
        //Se captura el error y se ingresa en una variable de tipo ListEmptyException
        ListEmptyException listEmptyException = Assertions.assertThrows(ListEmptyException.class, () -> vueloService.allVuelos());

        // Assert
        Assertions.assertEquals("La lista se encuentra vacia", listEmptyException.getMessage());
    }

    //______________________________US 005________________________________________

    //-------Comentar este bloque de codigo en dado caso que fallen los test
  @Test
    @DisplayName("US 0002: Lista de Vuelos disponibles")
    void testGetAllFlightsAvailable() {
        //Arrange
        ResponseVueloDTO responseDTO;

        //Act
        when(vueloRepository.returnVuelos()).thenReturn(flightList());
        responseDTO = vueloService.VuelosAvailable(
                new Date(2022, 02, 10),
                new Date(2022, 02, 20),
                "Buenos Aires","Puerto Iguazú");

        // Assert
        Assertions.assertFalse(!responseDTO.getVuelosRegistrados().isEmpty());
    }

    @Test
    @DisplayName("US 0002 Error en las fechas")
    void testGetAllFlightIsAvailable1() {
        //Arrange
        String message = "La fecha de salida debe ser mayor a la de entrada";
        //Act
        when(vueloRepository.returnVuelos()).thenReturn(flightList());
        //Assert
        BadDatePeriod badDatePeriod = Assertions.assertThrows(BadDatePeriod.class, () -> vueloService.VuelosAvailable(
                new Date(2022, 02, 20),
                new Date(2022, 02, 15),
                "Buenos Aires",
                "Puerto Iguazú"));

        Assertions.assertEquals(message, badDatePeriod.getMessage());
    }

    @Test
    @DisplayName("US 0002 destino no existe")
    void testGetAllFlightIsAvailable2() {
        //Act
        String message = "El destino u origen ingresado no existe";
        //Arrange
        when(vueloRepository.returnVuelos()).thenReturn(flightList());
        //Assert
        NoDestinationException noDestinationException = Assertions.assertThrows(NoDestinationException.class, () -> vueloService.VuelosAvailable(
                new Date(2022, 02, 20),
                new Date(2022, 02, 25),
                "Buenas",
                "Puerto Iguazú"));

        Assertions.assertEquals(message, noDestinationException.getMessage());
    }

    @Test
    @DisplayName("US 0002 la lista se encuentra vacia")
    void testGetAllFlightIsAvailable3() {
        //Arrange
        String message = "La lista se encuentra vacia";
        List<Vuelo> vuelos = new ArrayList<>();
        //Act
        when(vueloRepository.returnVuelos()).thenReturn(vuelos);
        //Assert
        ListEmptyException listEmptyException = Assertions.assertThrows(ListEmptyException.class, () -> vueloService.VuelosAvailable(
                new Date(2022, 02, 20),
                new Date(2022, 02, 15),
                "Buenas",
                "Puerto Iguazú"));

        Assertions.assertEquals(message, listEmptyException.getMessage());
    }

    //________________________________US 0006______________________________________

    @Test
    @DisplayName("US 0003: Reserva de Vuelo")
    void testPostFlightReservation0()
    {
        //Arrange
        ResponseReservationVueloDTO response;

        //Act
        when(vueloRepository.returnVuelos()).thenReturn(flightList());
        response = vueloService.reservaVuelo(payloadFlightDTO(), String.valueOf(HttpStatus.OK));

        System.out.println(response);

        // Assert
        Assertions.assertEquals(200, response.getStatusCode().getCode());
    }

    @Test
    @DisplayName("US 0003: El origen no existe.")
    void testNotPostFlightReservation()
    {
        //Arrange
        PayloadFlightDTO payloadVueloDTO = payloadFlightDTO();
        payloadVueloDTO.getFlightReservation().setOrigin("Mexico");

        //Act
        when(vueloRepository.returnVuelos()).thenReturn(flightList());
        NoDestinationException notDestinationException =
                Assertions.assertThrows(NoDestinationException.class,
                        ()-> {
                            vueloService.reservaVuelo(
                                    payloadVueloDTO,
                                    String.valueOf(HttpStatus.OK)
                            );
                        }
                );

        // Assert
        Assertions.assertEquals("El destino u origen ingresado no existe", notDestinationException.getMessage());
    }

    @Test
    @DisplayName("US 0003: El destino no existe.")
    void testNotPostFlightReservation0()
    {

        //Arrange
        PayloadFlightDTO payloadVueloDTO = payloadFlightDTO();
        payloadVueloDTO.getFlightReservation().setDestination("Mexico");

        //Act
        when(vueloRepository.returnVuelos()).thenReturn(flightList());
        NoDestinationException notDestinationException =
                Assertions.assertThrows(NoDestinationException.class,
                        ()-> {
                            vueloService.reservaVuelo(
                                    payloadVueloDTO,
                                    String.valueOf(HttpStatus.OK)
                            );
                        }
                );

        // Assert
        Assertions.assertEquals("El destino u origen ingresado no existe", notDestinationException.getMessage());
    }


    @Test
    @DisplayName("US 0003: fechade entrada mayor.")
    void testNotPostFlightReservation01()
    {
        //Arrange
        String message = "La fecha de salida debe ser mayor a la de entrada";
        PayloadFlightDTO payloadVueloDTO = payloadFlightDTO();
        payloadVueloDTO.getFlightReservation().setDateFrom(new Date(2022, 02,23));

        //Act
        when(vueloRepository.returnVuelos()).thenReturn(flightList());

        BadDatePeriod badDateException =
                Assertions.assertThrows(BadDatePeriod.class,
                        ()->  vueloService.reservaVuelo(
                                payloadVueloDTO,
                                String.valueOf(HttpStatus.OK)
                        )
                );

        // Assert
        Assertions.assertEquals(message, badDateException.getMessage());
    }


    @Test
    @DisplayName("US 0003: fecha de salida menor.")
    void testNotPostFlightReservation02()
    {
        //Arrange
        String message = "La fecha de salida debe ser mayor a la de entrada";
        PayloadFlightDTO payloadVueloDTO = payloadFlightDTO();
        payloadVueloDTO.getFlightReservation().setDateTo(new Date(2022, 02,10));

        //Act
        when(vueloRepository.returnVuelos()).thenReturn(flightList());

        BadDatePeriod badDateException =
                Assertions.assertThrows(BadDatePeriod.class,
                        ()->  vueloService.reservaVuelo(
                                payloadVueloDTO,
                                String.valueOf(HttpStatus.OK)
                        )
                );

        // Assert
        Assertions.assertEquals(message, badDateException.getMessage());
    }

    @Test
    @DisplayName("US 0003: Metodo de pago incompatible")
    void testNotPostFlightReservation05()
    {
        //Arrange
        String message = "El Tipo de pago que hiciste fue con DEBITO por favor poner 1 en su couta de pago";
        PayloadFlightDTO payloadVueloDTO = payloadFlightDTO();
        payloadVueloDTO.getFlightReservation().getPaymentMethod().setType("DEBIT");
        payloadVueloDTO.getFlightReservation().getPaymentMethod().setDues(6);

        //Act
        when(vueloRepository.returnVuelos()).thenReturn(flightList());

        PayMentCardException payMentCardException =
                Assertions.assertThrows(PayMentCardException.class,
                        ()->  vueloService.reservaVuelo(
                                payloadVueloDTO,
                                String.valueOf(HttpStatus.OK)
                        )
                );

        // Assert
        Assertions.assertEquals(message, payMentCardException.getMessage());
    }

    @Test
    @DisplayName("US 0003: Metodo de pago interes-tarjeta")
    void testNotPostFlightReservation06()
    {
        //Arrange
        String message = "El tipo de tiempo a interes no aplica, favor de ingresar uno de las siguientes opciones [1,2,3,4,5,6,10,11,12,16,17,18]";
        PayloadFlightDTO payloadVueloDTO = payloadFlightDTO();
        payloadVueloDTO.getFlightReservation().getPaymentMethod().setType("CREDIT");
        payloadVueloDTO.getFlightReservation().getPaymentMethod().setDues(19);

        //Act
        when(vueloRepository.returnVuelos()).thenReturn(flightList());

        InterestNotValidException interestNotValidException =
                Assertions.assertThrows(InterestNotValidException.class,
                        ()-> vueloService.reservaVuelo(
                                payloadVueloDTO,
                                String.valueOf(HttpStatus.OK)
                        )
                );

        // Assert
        Assertions.assertEquals(message, interestNotValidException.getMessage());
    }

    @Test
    @DisplayName("US 0003: Metodo de pago No valido")
    void testNotPostFlightReservation07()
    {
        //Arrange
        String message = "El pago solo se puede realizar por tarjeta";
        PayloadFlightDTO payloadVueloDTO = payloadFlightDTO();
        payloadVueloDTO.getFlightReservation().getPaymentMethod().setType("AGUACATE");
        payloadVueloDTO.getFlightReservation().getPaymentMethod().setDues(1);

        //Act
        when(vueloRepository.returnVuelos()).thenReturn(flightList());

        NoPaymentException cashInvalidException =
                Assertions.assertThrows(NoPaymentException.class,
                        ()-> vueloService.reservaVuelo(
                                payloadVueloDTO,
                                String.valueOf(HttpStatus.OK)
                        )
                );

        // Assert
        Assertions.assertEquals(message, cashInvalidException.getMessage());
    }


    private Vuelo flight1(){
        return new Vuelo("PIBA-1420","Buenos Aires","Puerto Iguazú","Business",23200, new Date(2022,2,10),new Date(2022,2,15));
    }

    private Vuelo flight2(){
        return new Vuelo("PIBA-1220","Puerto Iguazú","Buenos Aires","Business",35735, new Date(2022,2,11),new Date(2022,2,25));
    }

    private List<Vuelo> flightList(){
        List<Vuelo> flightList = new ArrayList<>();
        flightList.add(flight1());
        flightList.add(flight2());
        return flightList;
    }
    private PayloadFlightDTO payloadFlightDTO(){

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


        FlightReservationDTO flightReservationDTO = new FlightReservationDTO();
        flightReservationDTO.setDateFrom(new Date(2022, 02,15));
        flightReservationDTO.setDateTo(new Date(2022, 02,20));
        flightReservationDTO.setOrigin("Buenos Aires");
        flightReservationDTO.setDestination("Puerto Iguazú");
        flightReservationDTO.setFlightNumber("PIBA-1420");
        flightReservationDTO.setSeats(2);
        flightReservationDTO.setSeatType("Business");
        flightReservationDTO.setPeople(peopleDTO);
        flightReservationDTO.setPaymentMethod(paymentMethodDTO);

        PayloadFlightDTO payloadFlightlDTO = new PayloadFlightDTO();
        payloadFlightlDTO.setUserName("Mau");
        payloadFlightlDTO.setFlightReservation(flightReservationDTO);
        return payloadFlightlDTO;
    }
}
