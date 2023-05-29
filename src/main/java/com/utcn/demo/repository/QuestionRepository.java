package com.utcn.demo.repository;

import com.utcn.demo.entity.Question;
import com.utcn.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByOrderByCreationDateDesc();
    List<Question> findAllByTags_Name(String tagName);

    List<Question> findAllByUser_Email(String userEmail);

    //List<Question>
    List<Question> findAllByTitleContainingIgnoreCase(String title);
    //String findUser_EmailByContentID(Long contentID);

}