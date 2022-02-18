package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * @author Mauricio tapia
 */

public class Vuelo
{
        private String flightNumber;
        private String origin;
        private String destination;
        private String seatType;
        private int amount;
        @JsonFormat(pattern = "dd/MM/yyyy")
        private Date dateFrom;
        @JsonFormat(pattern = "dd/MM/yyyy")
        private Date dateTo;
}
