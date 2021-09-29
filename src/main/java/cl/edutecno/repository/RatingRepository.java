package cl.edutecno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.edutecno.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long>{

}
