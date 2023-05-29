package com.utcn.demo.service;

import com.utcn.demo.entity.Content;
import com.utcn.demo.entity.User;
import com.utcn.demo.repository.ContentRepository;
import com.utcn.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {
    @Autowired
    ContentRepository contentRepository;
    @Autowired
UserRepository userRepository;

    public List<Content> retrieveContents(){
        return (List<Content>) contentRepository.findAll();
    }

    public Content retrieveContentById(Long id){
        Optional<Content> content = contentRepository.findById(id);
        if(content.isPresent()){
            return content.get();
        }
        else{
            return null;
        }
    }

    public String deleteById(Long contentID){
        try{
            contentRepository.deleteById(contentID);
            return "Success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "Failed";
        }
    }
    public Content saveContent(Content content){

        return contentRepository.save(content);
    }
    public Content saveContent2(Content content, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        System.out.println(user);
        if (user.isPresent()) {
            content.setUser(user.get());
            return contentRepository.save(content);
        } else {
            // Handle the case when the user with the given ID is not found
            // You can throw an exception or return an appropriate response
            return null;
        }
    }

}
