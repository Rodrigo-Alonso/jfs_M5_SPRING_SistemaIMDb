package cl.edutecno.model.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ShowAvgRating {
	
	private Integer id;
	private String showTitle;
	private String showNetwork;
	private Double avgRating;

}
