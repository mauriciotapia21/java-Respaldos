package com.example.demo.Controller;
import com.example.demo.dto.certificadoDTO;
import com.example.demo.dto.estudianteDTO;
import com.example.demo.service.DiplomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDiploma
{
    @PostMapping("/certificado")
    public ResponseEntity<certificadoDTO> returnResponse(@RequestBody estudianteDTO alumnoDTO){
        DiplomaService serviceDiploma = new DiplomaService();
        return new ResponseEntity<certificadoDTO>(serviceDiploma.crearRespuesta(alumnoDTO), HttpStatus.OK);
    }
}
