package sv.edu.udb.spring_api_rest.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "perfiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id autoincremental
    private Long id;

    @Column(nullable = false)
    private String nombreCompleto;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String carnet;

    @Column(nullable = false)
    private String carrera;

    @Column(nullable = false)
    private String cohorte;
}