package com.utcn.demo;

import com.utcn.demo.controller.UserController;
import com.utcn.demo.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserTesting {

    @Autowired
    private UserController userController;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUserTest() {
        User user = new User();
        user.setUserId(252L);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("johndoe@example.com");
        user.setPhoneNr("1234567890");
        user.setPassword("password");
        user.setRole("user");

        User newUser = userController.insertUser(user);

        Assertions.assertNotNull(newUser);
    }

    @Test
    @Order(2)
    public void getUserTest() {
        User user = userController.retrieveById(252L);
        Assertions.assertEquals(252, user.getUserId());
    }

    @Test
    @Order(3)
    public void getAllUsersTest() {
        List<User> users = userController.retrieveUsers();
        Assertions.assertTrue(users.size() > 0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateUserTest() {
        User user = userController.retrieveById(252L);
        user.setEmail("testUpdate@gmail.com");

        User newUser = userController.updateUser( user);

        Assertions.assertEquals("testUpdate@gmail.com", newUser.getEmail());
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest() {
        userController.deleteById(252L);
        Optional<User> optionalUser = Optional.ofNullable(userController.retrieveById(252L));

        Assertions.assertTrue(optionalUser.isEmpty());
    }
}
