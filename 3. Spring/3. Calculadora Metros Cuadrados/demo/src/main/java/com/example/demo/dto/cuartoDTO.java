package com.example.demo.dto;

public class cuartoDTO {
    private String name;
    private Integer width;
    private Integer length;

    public cuartoDTO()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
    public Integer getSquareFeet() {
        Integer result = 0;
        if(this.width != null && this.length != null)
            result = this.width * this.length;
        return result;
    }

}
