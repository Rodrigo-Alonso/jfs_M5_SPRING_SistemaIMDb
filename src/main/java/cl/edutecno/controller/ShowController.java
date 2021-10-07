package cl.edutecno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import cl.edutecno.dto.RatingDTO;
import cl.edutecno.dto.ShowDTO;
import cl.edutecno.model.custom.IShowAvgRating;
import cl.edutecno.service.RatingService;
import cl.edutecno.service.ShowService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/shows")
public class ShowController {
	
	@Autowired
	private ShowService showService;
	
	@Autowired
	private RatingService ratingService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addShow(@RequestBody ShowDTO showDTO) {
		showService.save(showDTO);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ShowDTO> findAllShows() {
		return showService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ShowDTO findOneShow(@PathVariable Integer id) {
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

	@PostMapping("/rating")
	@ResponseStatus(HttpStatus.CREATED)
	public void addRating(@RequestBody RatingDTO ratingDTO) {
		ratingService.save(ratingDTO);
	}

	@GetMapping("/ratings")
	@ResponseStatus(HttpStatus.OK)
	public List<RatingDTO> findAllRatings() {
		return ratingService.findAll();
	}

	@GetMapping("/avgRatings/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Double avgRating(@PathVariable Integer id) {
		return ratingService.avgRatingByShowId(id);
	}

	@GetMapping("/ratingsByShow/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<RatingDTO> findRatingsByShowId(@PathVariable Integer id) {
		return ratingService.findAllByShowId(id);
	}
	
	@GetMapping("/showsAndRatings")
	@ResponseStatus(HttpStatus.OK)
	public List<IShowAvgRating> findShowsByRating() {
		return showService.findShowsByRatingAvg();
	}

//	@GetMapping("/showsAndRatings")
//	@ResponseStatus(HttpStatus.OK)
//	public List<List<String>> findShowsByAvgRating() {
//		List<?> response = ratingService.findShowsByRating();
//		List<List<String>> data = new ArrayList<List<String>>();
//		
//		for (Object object : response) {
//			//Cada Objeto encontrado
//			List<String> listShow = new ArrayList<String>();;
//			for (int i = 0; i < 4; i++) {
//				//Imprime sus elementos
//				
//				listShow.add(((Object[])object)[i].toString());
//				System.out.println(((Object[])object)[i].toString());
//			}
//			data.add(listShow);
//		}
//		return data;
//	}
	
	/*
	 * data in the JSON is not an ArrayList<String> instead it is a
	 * Map<String,List<String>>
	 */
//	@GetMapping("/showsAndRatings")
//	@ResponseStatus(HttpStatus.OK)
//	public Map<Integer, List<String>> findShowsByAvgRating() {
//		List<?> response = ratingService.findShowsByRating();
//		Map<Integer, List<String>> data = new HashMap<>();
//		int count = 0;
//		for (Object object : response) {
//			// Cada Objeto encontrado
//			List<String> listShow = new ArrayList<String>();
//			;
//			for (int i = 0; i < 4; i++) {
//				// Imprime sus elementos
//
//				listShow.add(((Object[]) object)[i].toString());
//				System.out.println(((Object[]) object)[i].toString());
//			}
//			data.put(count, listShow);
//			count++;
//		}
//		return data;
//	}

}
