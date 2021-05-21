package backend.food.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backend.food.domain.Step;

@Repository
@Transactional
public interface StepRepository extends JpaRepository<Step, Integer> {

	public Optional<Step> findByName(String name);

}
