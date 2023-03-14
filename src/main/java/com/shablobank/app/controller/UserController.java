/**package com.shablobank.app.controllers;

import com.shablobank.app.MainApplication;
import com.shablobank.app.models.User;
import com.shablobank.app.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    IUserRepository userRepository;


    @GetMapping("count-users")
    public String getCountUsers(){
        long numberUsers = userRepository.count();
        return "Number of users = "+numberUsers;
    }

  @GetMapping("add-user")
    public String addUser(){
        User user = new User();
        user.setFirstName("Render");
        user.setLastName("Spring Boot");
        userRepository.save(user);
        return "User added successfully";
    }
}**/
