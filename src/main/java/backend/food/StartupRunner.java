package backend.food;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import backend.food.domain.Ingredient;
import backend.food.domain.Nutrition;
import backend.food.domain.Recipe;
import backend.food.domain.Step;
import backend.food.domain.Tag;
import backend.food.service.IngredientService;
import backend.food.service.NutritionService;
import backend.food.service.RecipeService;
import backend.food.service.StepService;
import backend.food.service.TagService;
import backend.food.serviceImpl.StepServiceImpl;

@Component
public class StartupRunner implements CommandLineRunner {

	@Autowired
	private TagService tagServiceImpl;
	
	@Autowired
	private RecipeService recipeServiceImpl;
	
	@Autowired
	private StepService stepServiceImpl;
	
	@Autowired
	private IngredientService ingredientServiceImpl;
	
	@Autowired
	private NutritionService nutritionServiceImpl;

	@Override
	public void run(String... args) throws Exception {

		Tag tag = new Tag();
		tag.setName("rice");

		tagServiceImpl.createTag(tag);

		Tag tag2 = new Tag();
		tag2.setName("rice2");
		tagServiceImpl.createTag(tag2);

		Tag tag4 = new Tag();
		tag4.setName("rice2");
		// tagServiceImpl.createTag(tag4);

		Tag tag3 = tagServiceImpl.findTagByName("rice2").orElse(null);
		if (tag3 != null) {
			System.out.print(tag3.getName());
		}
		
		//Steps
		Step step=new Step("Boil");
		Step step2=new Step("Clean");
		
		stepServiceImpl.createStep(step);
		stepServiceImpl.createStep(step2);
		
		Ingredient ingredient=new Ingredient("Salt");
		ingredientServiceImpl.createIngredient(ingredient);
		
		Nutrition nutrition=new Nutrition(51.5, 0.0, 13.0, 0.0, 2.0, 0.0, 4.0);
		nutritionServiceImpl.createNutrition(nutrition);
		
		// Recipes
		//Integer id, String name, Integer minutes, Integer contributerId, LocalDate submitted
		//9/16/2005
		Recipe recipe=new Recipe(137739, "arriba   baked winter squash mexican style", 55, 47892, LocalDate.of(2005, 9, 16), "autumn is my favorite time of year to cook! this recipe \r\n"
				+ "can be prepared either spicy or sweet, your choice!\r\n"
				+ "two of my posted mexican-inspired seasoning mix recipes are offered as suggestions.");
		recipe.addTag(tag);
		recipe.addTag(tag2);
		recipe.addStep(step2);
		recipe.addStep(step);
		recipe.addIngredient(ingredient);
		recipe.setNutrition(nutrition);
		
		
		recipeServiceImpl.createRecipe(recipe);
	}

}