package cl.edutecno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.edutecno.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

	@Query(value = "SELECT AVG(r.rating) FROM rating r WHERE r.show_id = ?1", nativeQuery = true)
	Double ratingsPromedio(Integer id);

	@Query(value = "SELECT * FROM rating r WHERE r.show_id = ?1", nativeQuery = true)
	List<Rating> findAllRatingsByShowId(Integer id);
	
	//Eliminar show eliminando Ratings primero
	@Modifying //Can not issue data manipulation statements with executeQuery
	@Query(value = "DELETE FROM rating WHERE rating.show_id = ?1", nativeQuery = true)
	void deleteAllByShowId(Integer id);

}
