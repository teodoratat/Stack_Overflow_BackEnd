package com.utcn.demo.controller;

import com.utcn.demo.entity.Content;
import com.utcn.demo.entity.Question;
import com.utcn.demo.service.ContentService;
import com.utcn.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contents")
public class ContentController {
    @Autowired
    ContentService contentService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<Content> retrieveContents(){
        return contentService.retrieveContents();
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public Content retrieveContentById(@PathVariable Long id){

        return contentService.retrieveContentById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseBody
    public String deleteById(@PathVariable Long contentID){

        return contentService.deleteById(contentID);
    }
    @PostMapping("/insertContent")
    @ResponseBody
    public Content insertContent(@RequestBody Content content){

        return contentService.saveContent(content);
    }
    @PostMapping("/insertContent2")
    @ResponseBody
    public Content insertContent2(@RequestBody Content content,Long userId){

        return contentService.saveContent2(content,userId);
    }
    @PutMapping("/updateContent")
    @ResponseBody
    public Content updateContent(@RequestBody Content content){

        return contentService.saveContent(content);
    }


}


