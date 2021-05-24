package backend.food.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import backend.food.domain.Tag;
import backend.food.repository.TagRepository;
import backend.food.service.TagService;

@Service("tagServiceImpl")
public class TagServiceImpl implements TagService {

	@Autowired
	private TagRepository tagRepository;

	@Override
	public Tag createTag(Tag tag) {
		// TODO Auto-generated method stub
		return tagRepository.save(tag);
	}

	@Override
	public List<Tag> findAllTags() {
		// TODO Auto-generated method stub
		System.out.println("TagServiceImpl");
		return tagRepository.findAll();
	}

	@Override
	public Optional<Tag> findTagById(Integer tag) {
		// TODO Auto-generated method stub
		return tagRepository.findById(tag);
	}

	@Override
	public Optional<Tag> findTagByName(String name) {
		// TODO Auto-generated method stub
		return tagRepository.findByName(name);
	}
}
