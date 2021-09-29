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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.edutecno.dto.ShowDTO;
import cl.edutecno.service.ShowService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/shows")
public class ShowController {
	
	private ShowService showService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addShow(@RequestBody ShowDTO showDTO) {
		showService.save(showDTO);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ShowDTO> findAllShow() {
		return showService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ShowDTO findOneShow(@PathVariable Long id) {
		return showService.findById(id);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void updateShow(@RequestBody ShowDTO showDTO) {
		showService.update(showDTO);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deleteShow(@RequestBody ShowDTO showDTO) {
		showService.delete(showDTO);
	}

}
