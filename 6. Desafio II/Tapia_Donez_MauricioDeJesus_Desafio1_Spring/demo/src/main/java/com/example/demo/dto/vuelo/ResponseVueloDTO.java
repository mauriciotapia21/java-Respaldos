package com.example.demo.dto.vuelo;
import com.example.demo.entity.Vuelo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * @author Mauricio tapia*/

@Data
@NoArgsConstructor
@AllArgsConstructor
/**Esta clase me manda a llamar todos los vuelos registrados, me los trae desde mi json*/
public class ResponseVueloDTO
{
    private List<Vuelo> VuelosRegistrados;
}
