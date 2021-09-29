package cl.edutecno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import cl.edutecno.dto.RoleDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_ROLE")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE")
	private Roles role;
	
	//Convierte toDTO
	public RoleDTO toDTO() {
		RoleDTO roleDTO = new RoleDTO();
		
		roleDTO.setId(this.getId());
		roleDTO.setRole(this.getRole());
		
		return roleDTO;
	}
}
