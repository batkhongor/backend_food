package backend.food.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.food.domain.Interaction;
import backend.food.repository.InteractionRepository;
import backend.food.service.InteractionService;

@Service
public class InteractionServiceImpl implements InteractionService{
	
	@Autowired
	private InteractionRepository interactionRepository;
	
	@Override
	public List<Interaction> findAllInteractions() {
		// TODO Auto-generated method stub
		return interactionRepository.findAll();
	}

	@Override
	public Optional<Interaction> findInteractionById(Integer interaction) {
		// TODO Auto-generated method stub
		return interactionRepository.findById(interaction);
	}

	@Override
	public Interaction createInteraction(Interaction interaction) {
		// TODO Auto-generated method stub
		return interactionRepository.save(interaction);
	}

	@Override
	public Interaction updateInteraction(Interaction interaction) {
		// TODO Auto-generated method stub
		return interactionRepository.save(interaction) ;
	}
	
	
}
