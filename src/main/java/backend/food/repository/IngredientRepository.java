package backend.food.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backend.food.domain.Ingredient;

@Repository
@Transactional
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

	public Optional<Ingredient> findByName(String name);

}
