package backend.food.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.cfg.NotYetImplementedException;

import backend.food.domain.Interaction;

public interface InteractionService {

	// List of all Interactions

	public default List<Interaction> findAllInteractions() {
		throw new NotYetImplementedException();
	}

	public default Optional<Interaction> findInteractionById(Integer interaction) {
		throw new NotYetImplementedException();
	}

	public default Interaction createInteraction(Interaction interaction) {
		throw new NotYetImplementedException();
	}

	public default Interaction updateInteraction(Interaction interaction) {
		throw new NotYetImplementedException();
	}
}
