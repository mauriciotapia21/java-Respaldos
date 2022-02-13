package com.example.demo.dto;

public class casaResponseDTO extends casaDTO {
    private Integer squareFeet;
    private Integer price;
    private cuartoDTO biggest;

    public casaResponseDTO() {
    }

    public casaResponseDTO(casaDTO house) {
        this.setName(house.getName());
        this.setAddress(house.getAddress());
        this.setRooms(house.getRooms());
    }

    public Integer getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(Integer squareFeet) {
        this.squareFeet = squareFeet;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public cuartoDTO getBiggest() {
        return biggest;
    }

    public void setBiggest(cuartoDTO biggest) {
        this.biggest = biggest;
    }
}
