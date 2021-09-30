package cl.edutecno.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

	@Column(name = "rating")
	private int rating;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "show_id")
	private Show show;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
