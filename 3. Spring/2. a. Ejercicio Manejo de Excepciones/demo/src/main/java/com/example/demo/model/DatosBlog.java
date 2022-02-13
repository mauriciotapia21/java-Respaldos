package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class datosBlog {
    private long id;
    private String titulo;
    private String autor;
    private Date fecha;
}
