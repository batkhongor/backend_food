package backend.food.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backend.food.domain.Nutrition;

@Repository
@Transactional
public interface NutritionRepository extends JpaRepository<Nutrition, Integer> {

	public Optional<Nutrition> findByName(String name);

}
