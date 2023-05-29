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
    public Question retrieveById(@PathVariable Long contentID){

        return questionService.retrieveQuestionById(contentID);
    }
    @GetMapping("/getAllOrdered")
    @ResponseBody
    public List<Question> retrieveQuestionsByDateDescending(){
        return questionService.retrieveQuestionsByDateDescending();
    }

    @GetMapping("/getAllByTag")
    @ResponseBody
    public List<Question> retrieveQuestionsByTag(String tag){
        return questionService.getQuestionsByTagName(tag);
    }

    @GetMapping("/getAllByUser")
    @ResponseBody
    public List<Question> retrieveQuestionsByUser(String email){
        return questionService.getQuestionsByUserEmail(email);
    }


    @GetMapping("/getAllByTitle")
    @ResponseBody
    public List<Question> retrieveQuestionsByTitle(String title){
        return questionService.getQuestionsByTitle(title);
    }
    @DeleteMapping("/deleteById/{id}")
    @ResponseBody
    public String deleteById(@PathVariable Long contentID){

        return questionService.deleteById(contentID);
    }
    @PostMapping("/insertQuestion")
    @ResponseBody
    public Question insertQuestion(@RequestBody Question question){

        System.out.println("in controller am intrat");
        System.out.println(question.getTitle());
        System.out.println(question.getUser().getEmail());
        return questionService.saveQuestion(question);
    }

    @PostMapping("/insertQuestion3")
    @ResponseBody
    public Question insertQuestion3(@RequestBody Question question){

        return questionService.saveQuestion(question);
    }
    @PostMapping("/insertQuestion2")
    @ResponseBody
    public Question insertQuestion2(@RequestBody Question question,@RequestParam Long userId){


        return questionService.saveQuestion2(question,userId);
    }
//    @PostMapping("/insertQuestion2")
//    @ResponseBody
//    public Question insertQuestion2(@RequestBody Question question, String tags){
//
//        return questionService.insertQuestion(question,tags);
//    }
    @PutMapping("/updateQuestion")
    @ResponseBody
    public Question updateQuestion(@RequestBody Question question){

        return questionService.saveQuestion(question);
    }

    @PostMapping("/insertQuestion4")
    @ResponseBody
    public Question insertQuestion4(@RequestBody Question question){

        return questionService.saveQuestion4(question);
    }
}

