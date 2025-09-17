package sv.edu.udb.spring_api_rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Presponse {
    private Long id;
    private String nombreCompleto;
    private String apellido;
    private String carnet;
    private String carrera;
    private String cohorte;
}


