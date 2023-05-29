package com.utcn.demo.service;

import com.utcn.demo.entity.Answer;
import com.utcn.demo.entity.Content;
import com.utcn.demo.entity.Question;
import com.utcn.demo.entity.User;
import com.utcn.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> retrieveUsers() {

        return (List<User>) userRepository.findAll();
    }

    public User retrieveUserById(Long cnp) {
        Optional<User> user = userRepository.findById(cnp);
        if (user.isPresent()) {
            return (user.get());
        } else {
            return null;
        }
    }

    public User retrieveUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return (user.get());
        } else {
            return null;
        }
    }
    public List<User> getUsersWithNonModeratorRole() {
        return userRepository.findAllByRoleNot("moderator");
    }


    public User getUserByEmailAndPassword(String email, String password) {
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
           if(user.isPresent())
            return (user.get());
            else
            return null;
    }

    public String deleteById(Long cnp){
        try{
            userRepository.deleteById(cnp);
            return "Success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "Failed";
        }
    }

    public User saveUser(User user){

        return userRepository.save(user);
    }


}
