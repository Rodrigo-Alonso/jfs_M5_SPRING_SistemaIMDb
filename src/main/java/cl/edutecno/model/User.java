package cl.edutecno.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cl.edutecno.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_USER")
	private Long id;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "PASWORD_CONFIRMATION")
	private String passwordConfirmation;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name = "ROLES")
	private List<Role> roles;
	
//	convierte User en UserDTO
	public UserDTO toDTO() {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setId(this.getId());
		userDTO.setUsername(this.getUsername());
		userDTO.setEmail(this.getEmail());
		userDTO.setPassword(this.getPassword());
		userDTO.setRoles(this.getRoles());
		
		return userDTO;
	}
}
