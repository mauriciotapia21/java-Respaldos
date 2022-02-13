package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Hotel {
    private String codigoHotel;
    private String nombre;
    private String lugar_Ciudad;
    private String tipoDeHabitacion;
    private Integer precioPorNoche;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date disponibleDesde;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date disponibleHasta;
    private boolean reservado;

}
