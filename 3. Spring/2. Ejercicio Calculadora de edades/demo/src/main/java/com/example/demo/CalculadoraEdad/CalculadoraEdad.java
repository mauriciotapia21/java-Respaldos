package com.example.demo.CalculadoraEdad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.time.Period;


@RestController
public class CalculadoraEdad
{
    @GetMapping("/calculadora/{dia}/{mes}/{Año}")
                                    //Ingresamos nuestros parametros con el tipo de dato int
    public String CalculadoraEdad(@PathVariable int dia,@PathVariable int mes,@PathVariable int Año) {

        //Aqui se conseguira la fecha actual mediante el metodo localDate.now
        LocalDate DiaPresente = LocalDate.now();
        //Aqui se extrae la fecha ingresada
        LocalDate fechaNacimiento = LocalDate.of(Año, mes, dia);
        //Se hace una comparacion de las 2 fechas
        Period edad = Period.between(fechaNacimiento, DiaPresente);
        //Gracias al metodo LocalDate tenemos la posibilidad de extraer los años, esto se consigue a la
        // con la comparacion establecida y se muestra
        return "La edad que tu tienes es de: " + edad.getYears();
    }

}
