package cl.edutecno.utils;

import cl.edutecno.dto.RatingDTO;
import cl.edutecno.dto.ShowDTO;
import cl.edutecno.dto.UserDTO;
import cl.edutecno.model.Rating;
import cl.edutecno.model.Show;
import cl.edutecno.model.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DTOMapper {
	
	private static void userToEntity(UserDTO userDTO, User user) {
		user.setId(userDTO.getId());
		user.setUsername(userDTO.getUsername());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setPasswordConfirmation(userDTO.getPasswordConfirmation());
		user.setRoles(userDTO.getRoles());
	}
	
	public static User userToEntity(UserDTO userDTO) {
		User user = new User();
		userToEntity(userDTO, user);
		return user;
	}
	
	private static void showToEntity(ShowDTO showDTO, Show show) {
		show.setId(showDTO.getId());
		show.setShowTitle(showDTO.getShowTitle());
		show.setShowNetwork(showDTO.getShowNetwork());
	}
	
	public static Show showToEntity(ShowDTO showDTO) {
		Show show = new Show();
		showToEntity(showDTO, show);
		return show;
	}
	
	private static void ratingToEntity(RatingDTO ratingDTO, Rating rating) {
		rating.setId(ratingDTO.getId());
		rating.setRating(ratingDTO.getRating());
		rating.setShow(ratingDTO.getShow());
		rating.setUser(ratingDTO.getUser());
	}
	
	public static Rating ratingToEntity(RatingDTO ratingDTO) {
		Rating rating = new Rating();
		ratingToEntity(ratingDTO, rating);
		return rating;
	}
	
}
