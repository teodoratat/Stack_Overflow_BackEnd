package com.utcn.demo.service;

import com.utcn.demo.entity.Question;
import com.utcn.demo.entity.Tag;
import com.utcn.demo.repository.QuestionRepository;
import com.utcn.demo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    TagRepository tagRepository;
    public List<Question> retrieveQuestions(){
        return (List<Question>) questionRepository.findAll();
    }

    public List<Question> retrieveQuestionsByDateDescending() {
        return questionRepository.findAllByOrderByCreationDateDesc();
    }

    public Question retrieveQuestionById(Long id){
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()){
            return (question.get());
        }
        else
        {
            return null;
        }
    }

    public String deleteById(Long id){
        Optional<Question> question = questionRepository.findById(id);
        question.get().setTags(new HashSet<>());
        try {
            questionRepository.deleteById(id);
            return "Success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "Failed";
        }
    }

    public Question saveQuestion(Question question) {
        Set<String> tagNames = question.getTagNames();
        Set<Tag> tags = new HashSet<>();
        for(String tagName : tagNames){
            Tag tag = tagRepository.findByName(tagName);
            if(tag==null){
                tag = new Tag(tagName);
                tagRepository.save(tag);
            }
            tags.add(tag);
        }
        question.setTags(tags);
        return questionRepository.save(question);
    }
}




