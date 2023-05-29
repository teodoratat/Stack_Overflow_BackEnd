package com.utcn.demo.service;

import com.utcn.demo.entity.Answer;
import com.utcn.demo.entity.Question;
import com.utcn.demo.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public List<Answer> retrieveAnswers() {
        List<Answer> answers = answerRepository.findAll();
        return answers;
    }

    public Answer retrieveAnswerById(Long answerId) {
        Optional<Answer> answer = answerRepository.findById(answerId);
        if (answer.isPresent()) {
            return answer.get();
        } else {
            return null;
        }
    }

    public List<Answer> getAnswersByQuestion_Title(String title) {
        return answerRepository.findAllByQuestion_Title(title);
    }

    public Answer saveAnswer(Answer answer) {
        Answer savedAnswer = answerRepository.save(answer);
        return savedAnswer;
    }

    public String deleteAnswer(Long answerId) {

        try{
            answerRepository.deleteById(answerId);
            return "Success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "Failed";
        }
    }

}

