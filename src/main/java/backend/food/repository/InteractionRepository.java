package backend.food.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backend.food.domain.Ingredient;
import backend.food.domain.Interaction;

@Repository
@Transactional
public interface InteractionRepository extends JpaRepository<Interaction, Integer> {

}
