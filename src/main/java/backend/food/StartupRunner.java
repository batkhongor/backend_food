package backend.food;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import backend.food.domain.Tag;
import backend.food.service.TagService;
import backend.food.serviceImpl.TagServiceImpl;

@Component
public class StartupRunner implements CommandLineRunner {
	
	@Autowired
	private TagService tagServiceImpl; 
	
	@Override
	public void run(String... args) throws Exception {

		Tag tag=new Tag();
		tag.setName("rice");
		
		tagServiceImpl.createTag(tag);
		
		Tag tag2=new Tag();
		tag2.setName("rice2");		
		tagServiceImpl.createTag(tag2);
		
		Tag tag4=new Tag();
		tag4.setName("rice2");		
		tagServiceImpl.createTag(tag4);
		
		Tag tag3=tagServiceImpl.findTagByName("rice2").orElse(null);
		if(tag3!=null) {
			System.out.print(tag3.getName());
		}
		
		
	}

}