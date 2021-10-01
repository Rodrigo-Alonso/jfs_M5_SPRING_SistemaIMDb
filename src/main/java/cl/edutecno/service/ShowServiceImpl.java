package cl.edutecno.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edutecno.dto.ShowDTO;
import cl.edutecno.model.Show;
import cl.edutecno.repository.ShowRepository;
import cl.edutecno.utils.DTOMapper;

@Service
public class ShowServiceImpl implements ShowService{
	
	@Autowired
	private ShowRepository showRepository;

	@Override
	@Transactional(readOnly = false)
	public void save(ShowDTO showDTO) {
		showRepository.save(DTOMapper.showToEntity(showDTO));
	}

	@Override
	@Transactional(readOnly = false)
	public void update(ShowDTO showDTO) {
		showRepository.save(DTOMapper.showToEntity(showDTO));
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(ShowDTO showDTO) {
		showRepository.delete(DTOMapper.showToEntity(showDTO));
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShowDTO> findAll() {
		return showRepository.findAll().stream().map(Show::toDTO).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public ShowDTO findById(Integer id) {
		return showRepository.findById(id).orElse(new Show()).toDTO();
	}
	
	//APLICAR QUERY EN SHOWREPOSITORY O RATINGREPOSITORY ¡DEFINIR!
	@Override
	@Transactional(readOnly = true)
	public List<ShowDTO> findByRating(int rating) {
		return null;
	}
}
