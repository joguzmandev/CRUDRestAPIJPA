package net.jguzmandev.service;

import lombok.RequiredArgsConstructor;
import net.jguzmandev.dto.PersonaDTO;
import net.jguzmandev.dto.PersonaDetalleDTO;
import net.jguzmandev.mapper.PersonaMapper;
import net.jguzmandev.model.Persona;
import net.jguzmandev.repository.IPersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaService  implements IPersonaService{

    private final IPersonaRepository repository;

    private final PersonaMapper personaMapper;


    @Override
    public List<PersonaDTO> listarPersona() {

        return repository
                .findAll()
                .stream()
                .map(personaMapper::toDTO)
                .toList();

//        return repository.findAll().stream().map(p -> personaMapper.toDTO(p))
//                .toList();
    }

    @Override
    public PersonaDTO crearPersona(Persona persona) {
        Persona _newPerson = repository.save(persona);
        return personaMapper.toDTO(_newPerson);
    }

    @Override
    public void borrarPersona(Long id) {
        Persona p = repository.findById(id).get();
        repository.delete(p);
    }

    @Override
    public void modificarPersona(Persona persona) {
        repository.save(persona);
    }

    @Override
    public PersonaDetalleDTO buscarPersionaPorId(Long id) {
        Persona persona = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        return personaMapper.toDetalleDTO(persona);
    }
}
