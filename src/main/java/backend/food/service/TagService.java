package backend.food.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import backend.food.domain.Tag;


public interface TagService {

    //List of all tags

    public default List<Tag> findAllTags() {
        throw new NotYetImplementedException();
    }
    
    public default Optional<Tag> findTagById(Integer tag)
    {
        throw new NotYetImplementedException();
    }
    
    public default Optional<Tag> findTagByName(String name)
    {
        throw new NotYetImplementedException();
    }

    public default Tag createTag(Tag tag) {
        throw new NotYetImplementedException();
    }


    public default Tag updateTag(Tag tag) {
        throw new NotYetImplementedException();
    }
    
    public default  List<Tag> updateAllTag(List<Tag> tags) {
        throw new NotYetImplementedException();
    }
}

