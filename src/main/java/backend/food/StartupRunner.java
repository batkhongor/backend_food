package backend.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import backend.food.domain.Tag;
import backend.food.service.TagService;

@Component
public class StartupRunner implements CommandLineRunner {

	@Autowired
	private TagService tagServiceImpl;

	@Override
	public void run(String... args) throws Exception {

		Tag tag = new Tag();
		tag.setName("rice");

		tagServiceImpl.createTag(tag);

		Tag tag2 = new Tag();
		tag2.setName("rice2");
		tagServiceImpl.createTag(tag2);

		Tag tag4 = new Tag();
		tag4.setName("rice2");
		// tagServiceImpl.createTag(tag4);

		Tag tag3 = tagServiceImpl.findTagByName("rice2").orElse(null);
		if (tag3 != null) {
			System.out.print(tag3.getName());
		}

	}

}