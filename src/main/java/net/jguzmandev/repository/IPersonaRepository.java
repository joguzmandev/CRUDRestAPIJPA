package net.jguzmandev.repository;

import net.jguzmandev.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaRepository extends JpaRepository<Persona, Long> {
}
