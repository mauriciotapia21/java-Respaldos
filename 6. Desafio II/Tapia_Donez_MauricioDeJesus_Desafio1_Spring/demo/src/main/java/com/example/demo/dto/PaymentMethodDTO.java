package com.example.demo.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * @author Mauricio tapia
 */
public class PaymentMethodDTO
{
    private String type;
    private String number;
    private int dues;
}
