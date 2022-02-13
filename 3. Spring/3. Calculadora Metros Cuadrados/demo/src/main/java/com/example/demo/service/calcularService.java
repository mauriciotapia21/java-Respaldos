package com.example.demo.service;
import com.example.demo.dto.cuartoDTO;
import com.example.demo.dto.casaDTO;
import com.example.demo.dto.casaResponseDTO;

    public class calcularService {
        public casaResponseDTO calculate(casaDTO house) {
            casaResponseDTO response = new casaResponseDTO(house);
            calculateRoomSquareFeet(house, response);
            response.setPrice(calculatePrice(response.getSquareFeet()));
            return response;
        }

        private void calculateRoomSquareFeet(casaDTO house, casaResponseDTO response) {
            Integer totalSquareFeet = 0;
            cuartoDTO biggest = null;
            Integer maxRoom = 0;
            for (cuartoDTO room : house.getRooms()) {
                Integer squareFeet = room.getSquareFeet();
                totalSquareFeet += squareFeet;
                if (biggest == null || squareFeet > maxRoom){
                    biggest = room;
                    maxRoom = squareFeet;
                }
            }
            response.setSquareFeet(totalSquareFeet);
            response.setBiggest(biggest);
        }

        private int calculatePrice(Integer result) {
            return result * 800;
        }
}
