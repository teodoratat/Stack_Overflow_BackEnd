package com.utcn.demo.service;

import com.utcn.demo.entity.Content;
import com.utcn.demo.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {
    @Autowired
    ContentRepository contentRepository;


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

    public String deleteById(Long id){
        try{
            contentRepository.deleteById(id);
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
}
