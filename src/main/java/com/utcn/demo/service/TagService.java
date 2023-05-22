package com.utcn.demo.service;

import com.utcn.demo.entity.Tag;
import com.utcn.demo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    public List<Tag> retrieveAllTags() {
        return (List<Tag>) tagRepository.findAll();
    }

    public Optional<Tag> retrieveTagById(Long id) {
        return tagRepository.findById(id);
    }

    public void deleteTagById(Long id) {
        tagRepository.deleteById(id);
    }

    public void deleteTagByName(String name){
        Tag tag = tagRepository.findByName(name);
        if (tag != null){

            tagRepository.deleteById(tag.getId());
        }
    }

    public Tag saveTag(String name){
        Tag tag = tagRepository.findByName(name);
        if(tag == null){
            Tag newTag = new Tag(name);
            tagRepository.save(newTag);
            return newTag;
        }
        return tag;
    }

}
