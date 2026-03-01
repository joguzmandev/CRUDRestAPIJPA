package net.jguzmandev.repository;

import net.jguzmandev.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    @Query("SELECT m FROM Manager m JOIN FETCH m.shop WHERE m.managerId = :managerId")
    Manager getManagerWithShopById(Long managerId);
}
