package cl.edutecno.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edutecno.dto.RatingDTO;
import cl.edutecno.model.Rating;
import cl.edutecno.repository.RatingRepository;
import cl.edutecno.utils.DTOMapper;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	@Transactional(readOnly = false)
	public void save(RatingDTO ratingDTO) {
		ratingRepository.save(DTOMapper.ratingToEntity(ratingDTO));
	}

	@Override
	@Transactional(readOnly = true)
	public List<RatingDTO> findAll() {
		return ratingRepository.findAll().stream().map(Rating::toDTO).collect(Collectors.toList());
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<RatingDTO> findAllByShowId(Integer id) {
		return ratingRepository.findAllRatingsByShowId(id).stream().map(Rating::toDTO).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public Double avgRatingByShowId(Integer id) {
		return ratingRepository.ratingsPromedio(id);
	}
}
