package backend.food.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.cfg.NotYetImplementedException;

import backend.food.domain.Recipe;

public interface RecipeService {

	// List of all recipes

	public default List<Recipe> findAllRecipes() {
		throw new NotYetImplementedException();
	}

	public default Optional<Recipe> findRecipeById(Integer recipe) {
		throw new NotYetImplementedException();
	}

	public default Optional<Recipe> findRecipeByName(String name) {
		throw new NotYetImplementedException();
	}

	public default Recipe createRecipe(Recipe recipe) {
		throw new NotYetImplementedException();
	}

	public default Recipe updateRecipe(Recipe recipe) {
		throw new NotYetImplementedException();
	}

	public default List<Recipe> updateAllRecipe(List<Recipe> recipes) {
		throw new NotYetImplementedException();
	}
}
