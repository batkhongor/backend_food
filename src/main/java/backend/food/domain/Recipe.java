package backend.food.domain;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Recipe {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;

	@Column(nullable = false, unique = true)
	private String name;

	private Integer minutes;
	private Integer contributerId;
	private LocalDate submitted;
	
	@Column(columnDefinition = "TEXT")
	private String description;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "recipe_tag", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private Set<Tag> tags = new HashSet<Tag>();

	@Embedded
	private Nutrition nutrition;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "recipe_step", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "step_id"))
	private Map<Integer, Step> steps = new HashMap<Integer, Step>();

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "recipe_ingredient", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	private Set<Ingredient> ingredients = new HashSet<Ingredient>();
	
	
	public Recipe(Integer id, String name, Integer minutes, Integer contributerId, LocalDate submitted, String description) {
		this.id=id;
		this.name=name;
		this.minutes=minutes;
		this.contributerId=contributerId;
		this.submitted=submitted;
		this.description=description;
	}
	
	public void addTag(Tag tag) {
		this.tags.add(tag);
	}
	
	public void addStep(Step step) {
		this.steps.put(this.steps.size(), step);
	}
	
	public void addIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}
}
