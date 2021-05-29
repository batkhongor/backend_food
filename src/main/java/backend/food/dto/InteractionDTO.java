package backend.food.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.OneToOne;

import backend.food.domain.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @Getter @Setter 
@ToString
public class InteractionDTO {
	
	private String user_id;
	private Recipe recipe;
	private LocalDate date;
	private String action;
	private String value;
}