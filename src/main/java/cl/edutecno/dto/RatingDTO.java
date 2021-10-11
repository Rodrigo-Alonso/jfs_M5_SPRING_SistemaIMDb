package cl.edutecno.dto;

import cl.edutecno.model.Show;
import cl.edutecno.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingDTO {
	
	private Integer id;
	private int rating;
	private Show show;
//	private List<Show> show;
	private User user;
}
