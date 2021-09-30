package cl.edutecno.dto;

import cl.edutecno.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	
	private Integer id;
	private String username;
	private String email;
	private String password;
	private String passwordConfirmation;
	private Role role;
}
