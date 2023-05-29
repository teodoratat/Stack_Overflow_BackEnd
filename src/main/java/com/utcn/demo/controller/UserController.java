package com.utcn.demo.controller;

import com.utcn.demo.entity.Content;
import com.utcn.demo.entity.User;
import com.utcn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping( "/getAll")
    @ResponseBody
    public List<User> retrieveUsers() {

        return userService.retrieveUsers();
    }

    @GetMapping("/getById/{cnp}")
    @ResponseBody
    public User retrieveById( Long cnp){

        return userService.retrieveUserById(cnp);
    }

    @GetMapping("/getByEmail{email}")
    @ResponseBody
    public User retrieveByEmail(String email){
        return  userService.retrieveUserByEmail(email);}

    @GetMapping("/getById")
    @ResponseBody
    public User retrieveById1( Long cnp){

        return userService.retrieveUserById(cnp);
    }



    @GetMapping("/login")
    public ResponseEntity<User> getUserByEmailAndPassword(@RequestParam("email") String email, @RequestParam("password") String password) {
        User user = userService.getUserByEmailAndPassword(email, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getUsersWithNonModeratorRole();
    }

    @DeleteMapping("/deleteById/{cnp}")
    @ResponseBody
    public String deleteById(@PathVariable Long cnp){

        return userService.deleteById(cnp);
    }

    @PostMapping("/insertUser")
    @ResponseBody
    public User insertUser(@RequestBody User user){

        return userService.saveUser(user);
    }

    @PutMapping("/updateUser")
    @ResponseBody
    public User updateUser(@RequestBody User user){

        return userService.saveUser(user);
    }
}
