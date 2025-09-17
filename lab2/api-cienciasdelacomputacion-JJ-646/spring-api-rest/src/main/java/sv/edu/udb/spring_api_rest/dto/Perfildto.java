package sv.edu.udb.spring_api_rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Perfildto {

    @NotBlank(message = "Completar el nombre,el campo es obligatorio")
    private String nombreCompleto;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @NotBlank(message = "El carnet es obligatorio")
    @Size(min = 5, max = 15, message = "El carnet debe tener mas de 5 caracteres" +
            "s")
    private String carnet;

    @NotBlank(message = "La carrera es obligatoria")
    private String carrera;

    @NotBlank(message = "La cohorte es obligatoria")
    private String cohorte;
}