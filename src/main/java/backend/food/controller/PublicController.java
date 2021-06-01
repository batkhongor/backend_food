package backend.food.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.management.InvalidAttributeValueException;

import org.omg.CORBA.DynAnyPackage.InvalidValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import backend.food.domain.Ingredient;
import backend.food.domain.Interaction;
import backend.food.domain.Recipe;
import backend.food.domain.Step;
import backend.food.domain.Tag;
import backend.food.dto.InteractionDTO;
import backend.food.service.IngredientService;
import backend.food.service.InteractionService;
import backend.food.service.RecipeService;
import backend.food.service.StepService;
import backend.food.service.TagService;
import backend.food.serviceImpl.IngredientServiceImpl;
import javassist.NotFoundException;

@RestController
@RequestMapping("/public")
public class PublicController {

	@Autowired
	private TagService tagServiceImpl;

	@Autowired
	private RecipeService recipeServiceImpl;

	@Autowired
	private StepService stepServiceImpl;

	@Autowired
	private IngredientService ingredientServiceImpl;

	@Autowired
	private InteractionService interactionServiceImpl;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/tags")
	public List<Tag> getTagList() {
		List<Tag> page = tagServiceImpl.findAllTags();
		return page;
	}

	@GetMapping(value = "/tags/{name}")
	public ResponseEntity<Tag> getTagByName(@PathVariable(name = "name") String name) throws Exception {

		Optional<Tag> tag = tagServiceImpl.findTagByName(name);

		if (!tag.isPresent()) {
			String.join(" ", "Tag not found Value :", name);
			throw new NotFoundException(String.join(" ", "Tag not found Value :", name));
		}

		return new ResponseEntity<Tag>(tag.get(), HttpStatus.OK);
	}

	@PostMapping(value = "/tags/{name}")
	public ResponseEntity<Tag> addTag(@PathVariable(name = "name") String name) throws Exception {

		if (tagServiceImpl.findTagByName(name).isPresent()) {
			throw new DuplicateKeyException(String.join(" ", "Duplicate Value :", name));
		}

		Tag newTag = tagServiceImpl.createTag(new Tag(name));

		return new ResponseEntity<Tag>(newTag, HttpStatus.OK);
	}

	@GetMapping(value = "/steps/{name}")
	public ResponseEntity<Step> getStepByName(@PathVariable(name = "name") String name) throws Exception {

		Optional<Step> step = stepServiceImpl.findStepByName(name);

		if (!step.isPresent()) {
			String.join(" ", "Step not found Value :", name);
			throw new NotFoundException(String.join(" ", "Step not found Value :", name));
		}

		return new ResponseEntity<Step>(step.get(), HttpStatus.OK);
	}

	@PostMapping(value = "/steps/{name}")
	public ResponseEntity<Step> addStep(@PathVariable(name = "name") String name) throws Exception {

		if (stepServiceImpl.findStepByName(name).isPresent()) {
			throw new DuplicateKeyException(String.join(" ", "Duplicate Value :", name));
		}

		Step step = stepServiceImpl.createStep(new Step(name));

		return new ResponseEntity<Step>(step, HttpStatus.OK);
	}

	@PostMapping(value = "/ingredients/{name}")
	public ResponseEntity<Ingredient> addIngredient(@PathVariable(name = "name") String name) throws Exception {

		if (ingredientServiceImpl.findIngredientByName(name).isPresent()) {
			throw new DuplicateKeyException(String.join(" ", "Duplicate Value :", name));
		}

		Ingredient ingredient = ingredientServiceImpl.createIngredient(new Ingredient(name));

		return new ResponseEntity<Ingredient>(ingredient, HttpStatus.OK);
	}

	@GetMapping(value = "/ingredients/{name}")
	public ResponseEntity<Ingredient> getIngredientByName(@PathVariable(name = "name") String name) throws Exception {

		Optional<Ingredient> ingredient = ingredientServiceImpl.findIngredientByName(name);

		if (!ingredient.isPresent()) {
			System.out.println(String.join(" ", "Ingredient not found Value :", name));
			throw new NotFoundException(String.join(" ", "Ingredient not found Value :", name));
		}

		return new ResponseEntity<Ingredient>(ingredient.get(), HttpStatus.OK);
	}

	@GetMapping("/recipes")
	public List<Recipe> getRecipes() throws Exception {
		return recipeServiceImpl.findAllRecipes();
	}

	@GetMapping("/recipes/{id}")

	public ResponseEntity<Recipe> getRecipeById(@PathVariable(name = "id") Integer id) throws Exception {

		Optional<Recipe> recipe = recipeServiceImpl.findRecipeById(id);

		if (!recipe.isPresent()) {
			System.out.println(String.join(" ", "recipe not found Value :", id.toString()));
			throw new NotFoundException(String.join(" ", "recipe not found Value :", id.toString()));
		}

		return new ResponseEntity<Recipe>(recipe.get(), HttpStatus.OK);
	}

	@GetMapping("/recipes/{id}/related")
	public List<Recipe> getRelatedRecipes() throws Exception {

		// get list of related recipies using other microservices
		List<Object> recipies = restTemplate.getForObject("http://recommendation-service/recommendation/recipe/",
				List.class);
		
		List<Recipe> relatedRecipies= new ArrayList<>();
		
		for (int i = 0; i < recipies.size(); i++) {
			relatedRecipies.add(recipeServiceImpl.findRecipeById(Integer.valueOf(recipies.get(i).toString())).get());
		}

		return relatedRecipies;
	}

	@PostMapping("/recipes")
	public Recipe createRecipe(@RequestBody Recipe recipe) throws Exception {

		Optional<Recipe> recipeOld = recipeServiceImpl.findRecipeById(recipe.getId());

		if (recipeOld.isPresent()) {
			throw new DuplicateKeyException(String.join(" ", "Duplicate recipe Value :", recipe.getId().toString()));
		}

		return recipeServiceImpl.createRecipe(recipe);
	}

	@GetMapping("/interaction/{id}")
	public ResponseEntity<Interaction> getInteractionById(@PathVariable(name = "id") Integer id) throws Exception {

		Optional<Interaction> interaction = interactionServiceImpl.findInteractionById(id);

		if (!interaction.isPresent()) {
			System.out.println(String.join(" ", "interaction not found Value :", id.toString()));
			throw new NotFoundException(String.join(" ", "interaction not found Value :", id.toString()));
		}

		return new ResponseEntity<Interaction>(interaction.get(), HttpStatus.OK);
	}

	@PostMapping("/interactions")
	public Interaction createInteraction(@RequestBody InteractionDTO interactionDTO) throws Exception {

		if (interactionDTO.getRecipe() == null) {
			throw new NotFoundException("recipe not found ");
		}

		Interaction interaction = new Interaction(interactionDTO.getUser_id(), interactionDTO.getRecipe(),
				interactionDTO.getDate(), interactionDTO.getAction(), interactionDTO.getValue());

		String userId = interaction.getUser_id();
		Optional<Recipe> recipe = recipeServiceImpl.findRecipeById(interaction.getRecipe().getId());
		LocalDate date = interaction.getDate();
		String action = interaction.getAction();
		String value = interaction.getValue();

		if (!recipe.isPresent()) {
			throw new NotFoundException(
					String.join(" ", "recipe not found Value :", interaction.getRecipe().getId().toString()));
		}

		Interaction interactionNew = new Interaction(userId, recipe.get(), date, action, value);

		return interactionServiceImpl.createInteraction(interactionNew);
	}
}
