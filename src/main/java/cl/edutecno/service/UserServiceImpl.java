package cl.edutecno.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.edutecno.dto.UserDTO;
import cl.edutecno.exception.RestServiceException;
import cl.edutecno.model.User;
import cl.edutecno.repository.UserRepository;
import cl.edutecno.security.JwtTokenProvider;
import cl.edutecno.utils.DTOMapper;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	private UserRepository userRepository;

	// Inyeccion de nuevas utilidades de JWT para manejar autenticacion
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void update(UserDTO userDTO) {
		userRepository.save(DTOMapper.userToEntity(userDTO));
	}

	@Override
	public List<UserDTO> findAll() {
		// Busca User y luego transforma a USERDTO
		return userRepository.findAll().stream().map(User::toDTO).collect(Collectors.toList());
	}

	@Override
	public UserDTO findById(Integer id) {
		// findById si no encuentra, retorna un UserDTO vacio
		return userRepository.findById(id).orElse(new User()).toDTO();
	}

	@Override
	public void delete(UserDTO userDTO) {
		userRepository.delete(DTOMapper.userToEntity(userDTO));
	}

	@Override
	public String signIn(UserDTO userDTO) {
		try {
			// Validar datos de inicio de sesion
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));
			// Retorna token si los datos son correctos
			return jwtTokenProvider.createToken(userDTO.getUsername(),
					userRepository.findByUsername(userDTO.getUsername()).getRole());
		} catch (AuthenticationException e) {
			// Excepcion en caso de datos erroneos
			throw new RestServiceException("username o password invalido", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@Override
	public String signUp(UserDTO userDTO) {
		// Valida si el nombre de usuario no exista
		if (!userRepository.existsByUsername(userDTO.getUsername())) {
			// Se encripta contraseña
			userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
			// Se almacena el usuario
			userRepository.save(DTOMapper.userToEntity(userDTO));
			// Retrona token valido para este usuario
			return jwtTokenProvider.createToken(userDTO.getUsername(), userDTO.getRole());
		} else {
			// En caso de que nombre de usuario exista se retonra excepcion
			throw new RestServiceException("Username ya esta en uso", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Se busca usuario por su username
		final User user = userRepository.findByUsername(username);
		// Se evalua si usuario existe
		if (user == null) {
			// Si no existe se retorna excepcion de "Usuario no encontrado"
			throw new UsernameNotFoundException("Usuario '" + username + "' no encontrado");
		}
		// Si existe, se retorna un objeto de tipo UserDetails, validando contraseña y
		// su respectivo Rol.
		return org.springframework.security.core.userdetails.User.withUsername(username).password(user.getPassword())
				.authorities(user.getRole()).accountExpired(false).accountLocked(false).credentialsExpired(false)
				.disabled(false).build();
		// .authorities(user.getRoles().get(0).getRole()): Solo va a funcionar con el
		// primer Rol
	}

}
