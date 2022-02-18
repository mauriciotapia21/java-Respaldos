package com.example.demo.repository.Vuelo;

import com.example.demo.entity.Vuelo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;



@Repository
public class VueloRepositoryImple implements VueloRepository
{
    private List<Vuelo> databaseVuelo;
    public VueloRepositoryImple(){this.databaseVuelo = loadDatabseVuelo();}

    private List<Vuelo> loadDatabseVuelo()
    {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:flights.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Vuelo>> typeRef = new TypeReference<>() {};
        List<Vuelo> VueloList = null;
        try {
            VueloList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return VueloList;
    }
    public List <Vuelo> returnVuelos() {
        return databaseVuelo;
    }
}
