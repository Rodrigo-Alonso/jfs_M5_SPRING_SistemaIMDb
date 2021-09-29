package cl.edutecno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cl.edutecno.dto.ShowDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SHOW")
public class Show {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_SHOW")
	private Long id;

	@Column(name = "SHOW_TITLES")
	private String showTitle;

	@Column(name = "SHOW_NETWORK")
	private String showNetwork;

	// Convierte toDTO
	public ShowDTO toDto() {
		ShowDTO showDTO = new ShowDTO();

		showDTO.setId(this.getId());
		showDTO.setShowTitle(this.getShowTitle());
		showDTO.setShowNetwork(this.getShowNetwork());

		return showDTO;
	}

}
