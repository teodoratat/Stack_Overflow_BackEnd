package com.utcn.demo.controller;

import com.utcn.demo.entity.Answer;
import com.utcn.demo.entity.Tag;
import com.utcn.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<Tag> retrieveTags(){
        return tagService.retrieveAllTags();
    };

    @GetMapping("/getById/{id}")
    @ResponseBody
    public Optional<Tag> retrieveById(@PathVariable Long tagId){
        return tagService.retrieveTagById(tagId);
    }
    @DeleteMapping("/deleteById/{id}")
    @ResponseBody
    public String deleteById(@PathVariable Long tagId){

        return tagService.deleteTagById(tagId);
    }
    @PostMapping("/insertTag")
    public Tag insertTag(@RequestBody Tag tag){

        return tagService.saveTag2(tag);
    }
    @PostMapping("/insertTag2")
    public void createTag(@RequestBody String tag) {
        tagService.saveTag(tag);
    }


    @PutMapping("/updateTag")
    @ResponseBody
    public Tag updateTag(@RequestBody String name){

        return tagService.saveTag(name);
    }


}
