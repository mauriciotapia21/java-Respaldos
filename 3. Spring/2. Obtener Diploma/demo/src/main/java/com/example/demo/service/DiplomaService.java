package com.example.demo.service;
import com.example.demo.dto.certificadoDTO;
import com.example.demo.dto.estudianteDTO;
import com.example.demo.dto.materiaDTO;
import org.springframework.stereotype.Service;

@Service
public class DiplomaService
{
        public certificadoDTO crearRespuesta(estudianteDTO alumnoDTO){
            double promedio = alumnoDTO.getMateria().stream().mapToInt(materiaDTO::getCalificacion).average().orElse(0.0);
            String mensaje = "El alumno "+alumnoDTO.getNombre()+ " aprobó el curso con un promedio de "+promedio;
            if (promedio >= 9)
                mensaje = "Felicitamos al alumno "+alumnoDTO.getNombre()+" por aprobar el curso con un promedio sobresaliente de "+promedio;
            certificadoDTO respuesta = new certificadoDTO(mensaje);
            return respuesta;
        }
}
