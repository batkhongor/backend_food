package backend.food.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.food.domain.Nutrition;
import backend.food.repository.NutritionRepository;
import backend.food.service.NutritionService;
import backend.food.service.NutritionService;

@Service("NutritionServiceImpl")
public class NutritionServiceImpl implements NutritionService {

	@Autowired
	private NutritionRepository nutritionRepository;

	@Override
	public Nutrition createNutrition(Nutrition nutrition) {
		// TODO Auto-generated method stub
		return nutritionRepository.save(nutrition);
	}

	@Override
	public List<Nutrition> findAllNutritions() {
		// TODO Auto-generated method stub
		return nutritionRepository.findAll();
	}

	@Override
	public Optional<Nutrition> findNutritionById(Integer nutrition) {
		// TODO Auto-generated method stub
		return nutritionRepository.findById(nutrition);
	}

	@Override
	public Optional<Nutrition> findNutritionByName(String name) {
		// TODO Auto-generated method stub
		return nutritionRepository.findByName(name);
	}
}
