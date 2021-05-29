package backend.food.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Xp
 *
 */
@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Interaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;

	@Column(nullable = false)
	private String user_id;
	
	
	@OneToOne
	private Recipe recipe;
	
	private LocalDate date;
	
	private String action;
	
	private String value;

	public Interaction(String user_id, Recipe recipe, LocalDate date, String action, String value) {
		this.user_id = user_id;
		this.recipe = recipe;
		this.date = date;
		this.action = action;
		this.value = value;
	}
}
