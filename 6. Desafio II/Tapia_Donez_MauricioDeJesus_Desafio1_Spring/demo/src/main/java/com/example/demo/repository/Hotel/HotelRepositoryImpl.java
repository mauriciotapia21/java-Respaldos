package com.example.demo.repository.Hotel;
import com.example.demo.entity.Hotel;
import com.example.demo.repository.Hotel.HotelRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author Mauricio tapia
 */

/** Método para buscar en una BD tipo json todos los hoteles registrados
 * @return una lista de hoteles */
@Repository
public class HotelRepositoryImpl implements HotelRepository {
    private List<Hotel> dataBaseHotel;
    public  HotelRepositoryImpl() {
        this.dataBaseHotel = loadDataBase();
    }

    private List<Hotel> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:hotels.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Hotel>> typeRef = new TypeReference<>() {};
        List<Hotel> HotelList = null;
        try {
            HotelList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return HotelList;
    }

    /** Método para retornar todos los hoteles encontrados al service
     * @return una lista de hoteles */
    public List<Hotel> returnDB() {
        return dataBaseHotel;
    }

}

