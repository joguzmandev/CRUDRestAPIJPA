package net.jguzmandev.service;

import net.jguzmandev.dto.PersonaDTO;
import net.jguzmandev.dto.PersonaDetalleDTO;
import net.jguzmandev.exception.PersonaNotFoundException;
import net.jguzmandev.model.Persona;

import java.util.List;

public interface IPersonaService {

    List<PersonaDTO> listarPersona();
    PersonaDTO crearPersona(Persona persona);
    void borrarPersona(Long id);
    void modificarPersona(Persona persona);
    PersonaDetalleDTO buscarPersionaPorId(Long id) throws PersonaNotFoundException;
}
