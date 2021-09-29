package cl.edutecno.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "RATING")
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_RATING")
	private Long id;

	@Column(name = "RATING")
	private int rating;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SHOW_ID", referencedColumnName = "ID_SHOW")
	private Show show;

	// Convierte toDTO;
	public RatingDTO toDTO() {
		RatingDTO ratingDTO = new RatingDTO();

		ratingDTO.setId(this.getId());
		ratingDTO.setRating(this.getRating());
		ratingDTO.setShow(this.getShow());

		return ratingDTO;
	}
}
