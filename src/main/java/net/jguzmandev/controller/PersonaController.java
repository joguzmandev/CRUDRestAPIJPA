package net.jguzmandev.controller;

import lombok.RequiredArgsConstructor;
import net.jguzmandev.dto.PersonaDTO;
import net.jguzmandev.dto.PersonaDetalleDTO;
import net.jguzmandev.exception.PersonaNotFoundException;
import net.jguzmandev.model.Persona;
import net.jguzmandev.service.IPersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/personas")
public class PersonaController {

    private final IPersonaService personaService;

    @GetMapping
    public ResponseEntity<List<PersonaDTO>> listarPersona(){
        return ResponseEntity.ok(personaService.listarPersona());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDetalleDTO> buscarPersionaPorId(@PathVariable Long id)
            throws PersonaNotFoundException {
        return ResponseEntity.ok(personaService.buscarPersionaPorId(id));
    }

    @PostMapping
    public ResponseEntity<PersonaDTO> crearPersona(@RequestBody Persona persona){
        return ResponseEntity.ok(personaService.crearPersona(persona));
    }

    @DeleteMapping("/{id}")
    public void borrarPersona(@PathVariable Long id){
        personaService.borrarPersona(id);
    }

    @PutMapping("/{id}")
    public void modificarPersona(@RequestBody Persona persona){

        personaService.modificarPersona(persona);
    }
}
