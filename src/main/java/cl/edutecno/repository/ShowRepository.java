package cl.edutecno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.edutecno.model.Show;
import cl.edutecno.model.custom.IShowAvgRating;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {

//	@Query(value = "SELECT s.id, s.show_title, s.show_network, AVG(r.rating) FROM shows s\n"
//			+ "JOIN rating r ON r.show_id = s.id GROUP BY s.id", nativeQuery = true)
//	@Query("SELECT new cl.edutecno.model.custom.ShowAvgRating(s.id, s.show_title, s.show_network, AVG(r.rating)) "
//			+ "FROM shows s INNER JOIN s.rating r GROUP BY s.id")
//	public List<ShowAvgRating> findShowsByRatingAvg();

	@Query(value = "SELECT s.id AS id, s.show_title AS showTitle, s.show_network AS showNetwork, AVG(r.rating) AS avgRating "
			+ "FROM shows s LEFT JOIN rating r ON r.show_id = s.id GROUP BY s.id ORDER BY avgRating DESC", nativeQuery = true)
	List<IShowAvgRating> findShowsByRatingAvg();
	
}
