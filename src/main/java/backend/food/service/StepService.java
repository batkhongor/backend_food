package backend.food.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.cfg.NotYetImplementedException;

import backend.food.domain.Step;

public interface StepService {

	// List of all steps

	public default List<Step> findAllSteps() {
		throw new NotYetImplementedException();
	}

	public default Optional<Step> findStepById(Integer step) {
		throw new NotYetImplementedException();
	}

	public default Optional<Step> findStepByName(String name) {
		throw new NotYetImplementedException();
	}

	public default Step createStep(Step step) {
		throw new NotYetImplementedException();
	}

	public default Step updateStep(Step step) {
		throw new NotYetImplementedException();
	}

	public default List<Step> updateAllStep(List<Step> steps) {
		throw new NotYetImplementedException();
	}
}
