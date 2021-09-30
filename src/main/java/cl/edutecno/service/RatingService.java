package cl.edutecno.service;

import java.util.List;

import cl.edutecno.dto.RatingDTO;

public interface RatingService {
	
	void save(RatingDTO ratingDTO);
	List<RatingDTO> findAll();
	List<RatingDTO> findByShowId();
	//Long avgRating(Long id);

}
