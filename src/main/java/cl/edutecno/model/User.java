package cl.edutecno.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import cl.edutecno.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
/*
 * No serializer found for class
 * org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor and no properties
 * discovered to create BeanSerializer
 */
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "password_confirmation")
	private String passwordConfirmation;

//	@OneToMany(mappedBy = "user")
//	private List<Rating> ratings;

	@Enumerated(EnumType.STRING)
	private Role role;

//	convierte User en UserDTO
	public UserDTO toDTO() {
		UserDTO userDTO = new UserDTO();

		userDTO.setId(this.getId());
		userDTO.setUsername(this.getUsername());
		userDTO.setEmail(this.getEmail());
		userDTO.setPassword(this.getPassword());
		userDTO.setRole(this.getRole());

		return userDTO;
	}
}
