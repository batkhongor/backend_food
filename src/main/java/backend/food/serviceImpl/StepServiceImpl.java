package backend.food.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.food.domain.Step;
import backend.food.repository.StepRepository;
import backend.food.service.StepService;

@Service("stepServiceImpl")
public class StepServiceImpl implements StepService {

	@Autowired
	private StepRepository stepRepository;

	@Override
	public Step createStep(Step step) {
		// TODO Auto-generated method stub
		return stepRepository.save(step);
	}

	@Override
	public List<Step> findAllSteps() {
		// TODO Auto-generated method stub
		return stepRepository.findAll();
	}

	@Override
	public Optional<Step> findStepById(Integer step) {
		// TODO Auto-generated method stub
		return stepRepository.findById(step);
	}

	@Override
	public Optional<Step> findStepByName(String name) {
		// TODO Auto-generated method stub
		return stepRepository.findByName(name);
	}
}
