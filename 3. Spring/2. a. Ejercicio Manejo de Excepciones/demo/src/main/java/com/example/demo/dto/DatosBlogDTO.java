package com.example.demo.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class datosBlogDTO {
    private long id;
    private String titulo;
    private String autor;
    private Date fecha;
}
