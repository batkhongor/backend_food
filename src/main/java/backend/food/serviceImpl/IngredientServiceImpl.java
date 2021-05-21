package backend.food.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.food.domain.Ingredient;
import backend.food.domain.Tag;
import backend.food.repository.IngredientRepository;
import backend.food.repository.TagRepository;
import backend.food.service.IngredientService;
import backend.food.service.TagService;

@Service("ingredientServiceImpl")
public class IngredientServiceImpl implements IngredientService {

	@Autowired
	private IngredientRepository ingredientRepository;

	@Override
	public Ingredient createIngredient(Ingredient ingredient) {
		// TODO Auto-generated method stub
		return ingredientRepository.save(ingredient);
	}

	@Override
	public List<Ingredient> findAllIngredients() {
		// TODO Auto-generated method stub
		return ingredientRepository.findAll();
	}

	@Override
	public Optional<Ingredient> findIngredientById(Integer ingredientId) {
		// TODO Auto-generated method stub
		return ingredientRepository.findById(ingredientId);
	}

	@Override
	public Optional<Ingredient> findIngredientByName(String name) {
		// TODO Auto-generated method stub
		return ingredientRepository.findByName(name);
	}
}
