package com.example.demo.controller;
import com.example.demo.dto.cuartoDTO;
import com.example.demo.dto.casaDTO;
import com.example.demo.dto.casaResponseDTO;
import com.example.demo.service.calcularService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class calcularRestController {

    @PostMapping("/inmobiliaria")
    public ResponseEntity<casaResponseDTO> returnResponse(@RequestBody casaDTO propiedadDTO) {
        calcularService serviceInmobiliaria = new calcularService();
        return new ResponseEntity<casaResponseDTO>(serviceInmobiliaria.calculate(propiedadDTO), HttpStatus.OK);
    }
}
