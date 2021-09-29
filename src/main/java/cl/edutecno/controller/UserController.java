package cl.edutecno.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.edutecno.dto.UserDTO;
import cl.edutecno.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
	
	private UserService userService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<UserDTO> findAllUser() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UserDTO findOneUser(@PathVariable Long id) {
		return userService.findById(id);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void updateUser(@RequestBody UserDTO userDTO) {
		userService.update(userDTO);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@RequestBody UserDTO userDTO) {
		userService.delete(userDTO);
	}

	@PostMapping("/signin")
	public String loginUser(@RequestParam String username, @RequestParam String password) {
		return userService.signIn(username, password);
	}

	@PostMapping("/signup")
	@ResponseStatus(HttpStatus.CREATED)
	public String signupUser(@RequestBody UserDTO userDTO) {
		return userService.signUp(userDTO);
	}

}
