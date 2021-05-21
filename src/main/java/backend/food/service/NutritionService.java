package backend.food.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.cfg.NotYetImplementedException;

import backend.food.domain.Nutrition;

public interface NutritionService {

	// List of all Nutritions
	public default List<Nutrition> findAllNutritions() {
		throw new NotYetImplementedException();
	}

	public default Optional<Nutrition> findNutritionById(Integer nutritionId) {
		throw new NotYetImplementedException();
	}

	public default Optional<Nutrition> findNutritionByName(String name) {
		throw new NotYetImplementedException();
	}

	public default Nutrition createNutrition(Nutrition nutrition) {
		throw new NotYetImplementedException();
	}

	public default Nutrition updateNutrition(Nutrition nutrition) {
		throw new NotYetImplementedException();
	}

	public default List<Nutrition> updateAllNutrition(List<Nutrition> nutritions) {
		throw new NotYetImplementedException();
	}
}
