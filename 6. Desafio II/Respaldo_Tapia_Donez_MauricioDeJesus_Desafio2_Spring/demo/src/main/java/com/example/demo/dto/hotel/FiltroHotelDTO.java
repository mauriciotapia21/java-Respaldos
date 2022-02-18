package com.example.demo.dto.hotel;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * @author Mauricio tapia
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiltroHotelDTO
{
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateFrom;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateTo;
    private String destination;
}
