package com.utcn.demo.controller;

import com.utcn.demo.entity.Answer;
import com.utcn.demo.entity.Question;
import com.utcn.demo.service.AnswerService;
import com.utcn.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<Question> retrieveQuestions(){
        return questionService.retrieveQuestions();
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public Question retrieveById(@PathVariable Long id){

        return questionService.retrieveQuestionById(id);
    }
    @GetMapping("/getAllOrdered")
    @ResponseBody
    public List<Question> retrieveQuestionsByDateDescending(){
        return questionService.retrieveQuestionsByDateDescending();
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseBody
    public String deleteById(@PathVariable Long id){

        return questionService.deleteById(id);
    }
    @PostMapping("/insertQuestion")
    @ResponseBody
    public Question insertQuestion(@RequestBody Question question){

        return questionService.saveQuestion(question);
    }

    @PostMapping("/updateQuestion")
    @ResponseBody
    public Question updateQuestion(@RequestBody Question question){

        return questionService.saveQuestion(question);
    }
}

