package net.jguzmandev.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonaDetalleDTO {
    private Long id;
    private String nombreCompleto;
}
