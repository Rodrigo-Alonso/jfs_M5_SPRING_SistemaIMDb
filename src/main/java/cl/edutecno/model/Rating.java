package cl.edutecno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cl.edutecno.dto.RatingDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rating")
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Max(5)
	@Min(1)
	@Column(name = "rating")
	private int rating;
	
	//Eliminar Shows y sus respectivos rating N:N
//	@ManyToMany(mappedBy = "ratings")
//	private List<Show> shows;
	
	@JsonIgnore //Tomcat exception Cannot call sendError() after the response has been committed?
//	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "show_id")
	private Show show;
	
	@JsonIgnore
	//@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	// Convierte toDTO;
	public RatingDTO toDTO() {
		RatingDTO ratingDTO = new RatingDTO();

		ratingDTO.setId(this.getId());
		ratingDTO.setRating(this.getRating());
		ratingDTO.setShow(this.getShow());
		ratingDTO.setUser(this.getUser());

		return ratingDTO;
	}
}
