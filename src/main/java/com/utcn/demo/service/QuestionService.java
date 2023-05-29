package com.utcn.demo.service;

import com.utcn.demo.entity.Question;
import com.utcn.demo.entity.Tag;
import com.utcn.demo.entity.User;
import com.utcn.demo.repository.ContentRepository;
import com.utcn.demo.repository.QuestionRepository;
import com.utcn.demo.repository.TagRepository;
import com.utcn.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TagRepository tagRepository;
    @Autowired
    ContentRepository contentRepository;

    public List<Question> retrieveQuestions(){
        return (List<Question>) questionRepository.findAll();
    }

    public List<Question> retrieveQuestionsByDateDescending() {
        return questionRepository.findAllByOrderByCreationDateDesc();
    }

    public Question retrieveQuestionById(Long contentID){
        Optional<Question> question = questionRepository.findById(contentID);
        if(question.isPresent()){
            return (question.get());
        }
        else
        {
            return null;
        }
    }

    public String deleteById(Long contentID){
        Optional<Question> question = questionRepository.findById(contentID);
        question.get().setTags(new HashSet<>());
        try {
            questionRepository.deleteById(contentID);
            return "Success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "Failed";
        }
    }
    public Question saveQuestion4(Question question){
        return questionRepository.save(question);
    }


    public Question saveQuestion3(Question question){
        return questionRepository.save(question);
    }
    public Question saveQuestion(Question question) {
        System.out.println("is in service");
        System.out.println(question.getTitle());
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
        System.out.println("tot in service");
        System.out.println(question.getUser().getEmail());
        return questionRepository.save(question);
    }

    public List<Question> getQuestionsByTagName(String tagName) {
        return questionRepository.findAllByTags_Name(tagName);
    }

    public List<Question> getQuestionsByUserEmail(String userEmail) {
        return questionRepository.findAllByUser_Email(userEmail);
    }

    public List<Question> getQuestionsByTitle(String title) {
        return questionRepository.findAllByTitleContainingIgnoreCase(title);
    }

    public Question insertQuestion(Question question, String tags) {
        question = questionRepository.save(question);

        String[] tagNameArray = tags.split(",");
        for (String tagName : tagNameArray) {
            Optional<Tag> tagOpt = Optional.ofNullable(tagRepository.findByName(tagName.trim()));
            if (tagOpt.isPresent()) {
                Tag tag = tagOpt.get();
                if (!question.getTags().contains(tag)) {
                    question.addTag(tag);
                }
            } else {
                Tag tag = new Tag(tagName.trim());
                tagRepository.save(tag);
                question.addTag(tag);
            }
        }

        return questionRepository.save(question);
    }

    public Question saveQuestion2(Question question, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        System.out.println(user+"lalala");
        if (user.isPresent()) {
            question.setUser(user.get());
            return questionRepository.save(question);
        } else {
            return null;
        }
    }
}




