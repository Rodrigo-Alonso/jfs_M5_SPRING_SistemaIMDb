package cl.edutecno.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import cl.edutecno.dto.ShowDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shows")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Show {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "show_title")
	private String showTitle;

	@Column(name = "show_network")
	private String showNetwork;
	
	@OneToMany(mappedBy = "show")
	private List<Rating> ratings;

	// Convierte toDTO
	public ShowDTO toDTO() {
		ShowDTO showDTO = new ShowDTO();

		showDTO.setId(this.getId());
		showDTO.setShowTitle(this.getShowTitle());
		showDTO.setShowNetwork(this.getShowNetwork());

		return showDTO;
	}

}
