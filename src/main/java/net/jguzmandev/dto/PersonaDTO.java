package net.jguzmandev.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class PersonaDTO {

    private Long id;
    private String ubicacion;
    private String posicion;
    private String nombreCompleto;
    private String image;



}
