package com.example.demo.NumereosRomanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanos {
    @GetMapping("/{numero}")
    public String NumerosRomanos(@PathVariable int numero) {
        StringBuilder NumerosRomano = new StringBuilder();
        int[] numbersToCompare = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        String[] romanNumbers = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};

        if (numero <= 3999) {
            for (int i = 0; i < numbersToCompare.length; i++)
                for (; numero >= numbersToCompare[i]; numero -= numbersToCompare[i])
                    NumerosRomano.append(romanNumbers[i]);
        } else {
            return "No hay mas numeros despues de 3999";
        }
        return NumerosRomano.toString();
    }
}