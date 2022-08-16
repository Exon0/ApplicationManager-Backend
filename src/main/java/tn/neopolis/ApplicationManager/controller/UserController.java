package tn.neopolis.ApplicationManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.neopolis.ApplicationManager.models.User;
import tn.neopolis.ApplicationManager.services.UserService;

import java.util.List;

@Repository
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public List<User> getUsers(){
        List<User> USERS = userService.getAllUsers();
        return USERS ;
    }
}
