package backend.food.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.cfg.NotYetImplementedException;

import backend.food.domain.Ingredient;

public interface IngredientService {

	// List of all Ingredients

	public default List<Ingredient> findAllIngredients() {
		throw new NotYetImplementedException();
	}

	public default Optional<Ingredient> findIngredientById(Integer ingredient) {
		throw new NotYetImplementedException();
	}

	public default Optional<Ingredient> findIngredientByName(String name) {
		throw new NotYetImplementedException();
	}

	public default Ingredient createIngredient(Ingredient ingredient) {
		throw new NotYetImplementedException();
	}

	public default Ingredient updateIngredient(Ingredient ingredient) {
		throw new NotYetImplementedException();
	}

	public default List<Ingredient> updateAllIngredient(List<Ingredient> ingredients) {
		throw new NotYetImplementedException();
	}
}
