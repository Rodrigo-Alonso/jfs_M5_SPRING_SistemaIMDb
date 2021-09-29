package cl.edutecno.dto;

import java.util.List;

import cl.edutecno.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	
	private Long id;
	private String username;
	private String email;
	private String password;
	private String passwordConfirmation;
	private List<Role> roles;
}
