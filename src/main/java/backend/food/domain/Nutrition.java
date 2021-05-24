package backend.food.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Nutrition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;

	// calories (#)
	private Double calories;
	// total fat (PDV),
	private Double totalfat;
	// sugar (PDV)
	private Double sugar;
	// sodium (PDV)
	private Double sodium;
	// protein (PDV)
	private Double protein;
	// saturated fat (PDV)
	private Double saturatedfat;
	// carbohydrates (PDV)
	private Double carbohydrates;

	public Nutrition(Double calories, Double totalfat, Double sugar, Double sodium, Double protein, Double saturatedfat,
			Double carbohydrates) {

		this.calories = calories;
		this.totalfat = totalfat;
		this.sugar = sugar;
		this.sodium = sodium;
		this.protein = protein;
		this.saturatedfat = saturatedfat;
		this.carbohydrates = carbohydrates;
	}

}
