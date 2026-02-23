package net.jguzmandev.mapper;

import net.jguzmandev.dto.PersonaDTO;
import net.jguzmandev.dto.PersonaDetalleDTO;
import net.jguzmandev.model.Persona;
import org.springframework.stereotype.Component;

@Component
public class PersonaMapper {

    // Entity → DTO
    public PersonaDTO toDTO(Persona persona){
        return PersonaDTO.builder()
                .id(persona.getId())
                .ubicacion(persona.getUbicacion())
                .posicion(persona.getPosicion())
                .nombreCompleto(persona.getNombreCompleto())
                .image(persona.getImage())
                .build();
    }

    public PersonaDetalleDTO toDetalleDTO(Persona persona){
        return PersonaDetalleDTO.builder()
                .id(persona.getId())
                .nombreCompleto(persona.getNombreCompleto())
                .build();
    }

    // DTO → Entity
    public Persona toEntity(PersonaDTO dto){
        return Persona.builder()
                .ubicacion(dto.getUbicacion())
                .posicion(dto.getPosicion())
                .nombreCompleto(dto.getNombreCompleto())
                .image(dto.getImage())
                .build();
    }
}
