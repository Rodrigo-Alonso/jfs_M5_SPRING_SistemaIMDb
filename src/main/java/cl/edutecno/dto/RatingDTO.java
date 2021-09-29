package cl.edutecno.dto;

import cl.edutecno.model.Show;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingDTO {
	
	private Long id;
	private int rating;
	private Show show;
}
