package kz.webdogovor.repository;

import kz.webdogovor.model.SpravRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoleRepository extends JpaRepository<SpravRole, Long> {
    SpravRole findSpravRoleByRoleId(Long id);
    Set<SpravRole> findAllByRoleIdIsGreaterThan(Long id);
}
