package backend.food.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.food.domain.Tag;
import backend.food.service.TagService;

@RestController
@RequestMapping("/public")
public class PublicController {
	
	
	@Autowired
	private TagService tagServiceImpl;
	
	
	@GetMapping(value = "/tags")
	public List<Tag> getTagList() {
		List<Tag> page = tagServiceImpl.findAllTags();
		return page;
	}
	
	@PostMapping(value = "/tags/{name}")
	public ResponseEntity<Tag> addTag(@PathVariable(name = "name") String name) throws Exception {
		
		
		Tag newTag=null;
		
		if(!tagServiceImpl.findTagByName(name).isPresent())
		{
			newTag=tagServiceImpl.createTag(new Tag(name));
		}
		else {
			throw new HttpMessageNotReadableException("Tag not found");
		}
		
		return new ResponseEntity<Tag>(newTag,HttpStatus.OK);
	}
}
