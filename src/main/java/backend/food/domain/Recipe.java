package backend.food.domain;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

	private int minutes;
	private int contributerId;
	private LocalDate submitted;

	@ManyToMany
	@JoinTable(name = "recipe_tag", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private Set<Tag> tags = new HashSet<Tag>();

	@OneToOne(cascade = CascadeType.PERSIST)
	private Nutrition nutrition;

	@ManyToMany
	@JoinTable(name = "recipe_step", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "step_id"))
	private Map<Integer, Step> steps = new HashMap<Integer, Step>();

	public void addTag(Tag tag) {
		this.tags.add(tag);
	}
	
	public void addStep(Step step) {
		this.steps.put(this.steps.size(), step);
	}
}
