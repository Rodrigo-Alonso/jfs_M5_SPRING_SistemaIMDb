package cl.edutecno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.edutecno.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	boolean existsByUsername(String username);
	User findByUsername(String username);
}
