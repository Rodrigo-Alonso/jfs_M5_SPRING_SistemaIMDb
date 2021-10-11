package cl.edutecno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	//Eliminar Shows y sus respectivos rating N:N
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name = "shows_ratings", joinColumns = @JoinColumn(name = "show_id"), inverseJoinColumns = @JoinColumn(name = "rating_id"))
//	private List<Rating> ratings;
	
	//Eliminar Shows y sus respectivos rating 1:N
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "show", fetch = FetchType.LAZY)
//	private List<Rating> ratings;

	// Convierte toDTO
	public ShowDTO toDTO() {
		ShowDTO showDTO = new ShowDTO();

		showDTO.setId(this.getId());
		showDTO.setShowTitle(this.getShowTitle());
		showDTO.setShowNetwork(this.getShowNetwork());

		return showDTO;
	}

}
