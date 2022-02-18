package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * @author Mauricio tapia
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private String name;
    private String Description;
}
