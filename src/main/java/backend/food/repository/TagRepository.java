package backend.food.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import backend.food.domain.Tag;



@Repository
@Transactional
public interface TagRepository extends JpaRepository<Tag, Integer> {
	 
	public Optional<Tag> findByName(String name);
	

}
