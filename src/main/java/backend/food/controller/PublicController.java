package backend.food.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.management.InvalidAttributeValueException;
import javax.validation.Valid;

import org.omg.CORBA.DynAnyPackage.InvalidValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import backend.food.domain.Ingredient;
import backend.food.domain.Recipe;
import backend.food.domain.Step;
import backend.food.domain.Tag;
import backend.food.service.IngredientService;
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

	@GetMapping(value = "/tags")
	public List<Tag> getTagList() {
		List<Tag> page = tagServiceImpl.findAllTags();
		return page;
	}

	@GetMapping(value = "/tags/{name}")
	public ResponseEntity<Tag> getTagByName(@PathVariable(name = "name") String name) throws Exception {

		Optional<Tag> tag = tagServiceImpl.findTagByName(name);

		if (!tag.isPresent()) {
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
			throw new NotFoundException(String.join(" ", "Ingredient not found Value :", name));
		}

		return new ResponseEntity<Ingredient>(ingredient.get(), HttpStatus.OK);
	}

	@GetMapping("/recipes")
	public List<Recipe> getRecipes() throws Exception {
		return recipeServiceImpl.findAllRecipes();
	}

	@PostMapping("/recipes")
	public Recipe createRecipe(@RequestBody Recipe recipe) throws Exception {
		
		Recipe entity = recipe;
		Set<Tag> tags = recipe.getTags();
		for (Tag t : tags) {
			
			Tag tempTag = tagServiceImpl.findTagByName(t.getName()).orElse(null);
			if (tempTag != null) {
				System.out.println(String.join(" ", "Tag name:", tempTag.getName()));
			} else {
				tagServiceImpl.createTag(new Tag(t.getName()));
			}

		}

		entity = recipeServiceImpl.createRecipe(recipe);
		return entity;
	}
}
