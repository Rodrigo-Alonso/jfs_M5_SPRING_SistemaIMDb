package cl.edutecno.dto;

import cl.edutecno.model.Roles;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDTO {
	
	private Long id;
	private Roles role;
}
