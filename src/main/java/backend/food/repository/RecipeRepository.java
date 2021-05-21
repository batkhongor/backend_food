package backend.food.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backend.food.domain.Recipe;

@Repository
@Transactional
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

	public Optional<Recipe> findByName(String name);

}
