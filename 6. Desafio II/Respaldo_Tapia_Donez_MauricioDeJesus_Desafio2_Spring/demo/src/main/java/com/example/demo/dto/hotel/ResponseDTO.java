package com.example.demo.dto.hotel;
import com.example.demo.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * @author Mauricio tapia
 */

public class ResponseDTO
{
    private List<Hotel> hotelesResgistrados;
}
