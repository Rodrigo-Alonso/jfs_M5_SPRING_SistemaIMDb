package cl.edutecno.service;

import java.util.List;

import cl.edutecno.dto.ShowDTO;

public interface ShowService {
	
	void save(ShowDTO showDTO);
	void update(ShowDTO showDTO);
	void delete(ShowDTO showDTO);
	List<ShowDTO> findAll();
	ShowDTO findById(Long id);
	List<ShowDTO> findByRating(int rating);
	
	
}
