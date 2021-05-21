package backend.food.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.food.domain.Recipe;
import backend.food.repository.RecipeRepository;
import backend.food.service.RecipeService;

@Service("recipeServiceImpl")
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;

	@Override
	public Recipe createRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		return recipeRepository.save(recipe);
	}

	@Override
	public List<Recipe> findAllRecipes() {
		// TODO Auto-generated method stub
		return recipeRepository.findAll();
	}

	@Override
	public Optional<Recipe> findRecipeById(Integer recipe) {
		// TODO Auto-generated method stub
		return recipeRepository.findById(recipe);
	}

	@Override
	public Optional<Recipe> findRecipeByName(String name) {
		// TODO Auto-generated method stub
		return recipeRepository.findByName(name);
	}
}
