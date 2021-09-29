package cl.edutecno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.edutecno.model.Role_prueba;

@Repository
public interface RoleRepository extends JpaRepository<Role_prueba, Long>{

}
