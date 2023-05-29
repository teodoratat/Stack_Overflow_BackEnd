package com.utcn.demo.service;

import com.utcn.demo.entity.Answer;
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

    public Optional<Tag> retrieveTagById(Long tagId) {
        return tagRepository.findById(tagId);
    }

    public String deleteTagById(Long tagId) {
        tagRepository.deleteById(tagId);
        return null;
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
    public Tag saveTag2(Tag tag) {
       Tag savedTag = tagRepository.save(tag);
       return savedTag;
    }


}
