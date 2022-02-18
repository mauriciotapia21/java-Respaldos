package com.example.demo.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.util.Date;

/**
 * @author Mauricio tapia */

@Data
@NoArgsConstructor
@AllArgsConstructor
/** esta clase permite hacer el registro o ingreso de datos de la persona*/
public class PersonaDTO
{
    private long dni;
    private String name;
    private String lastname;
    @JsonFormat(pattern = "dd/MM/yyyy")
    Date birthDate;
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",message = "Email no valido.")
    private String mail;

}
