package cl.edutecno.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import cl.edutecno.dto.UserDTO;

public interface UserService {
	
	void update(UserDTO userDTO);
	List<UserDTO> findAll();
	UserDTO findById(Long id);
	void delete(UserDTO userDTO);
	String signIn(String username, String password);
	String signUp(UserDTO userDTO);
	UserDetails loadUserByUsername(String username);

}
