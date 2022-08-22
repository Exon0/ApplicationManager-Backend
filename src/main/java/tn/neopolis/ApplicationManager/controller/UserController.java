package tn.neopolis.ApplicationManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.neopolis.ApplicationManager.exceptions.UserNotFoundException;
import tn.neopolis.ApplicationManager.models.User;
import tn.neopolis.ApplicationManager.services.UserService;

import java.util.List;

@Controller
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
    @PreAuthorize("hasPermission(#id, 'supp_rimerUser')")
    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable Long id) throws UserNotFoundException {
        User user = userService.getUserById(id);
        return user;
    }

    @PostMapping(value = "")
    public User addUser(@RequestBody User user){
        User user1 = userService.createUser(user);
        return user1;
    }
    @PutMapping(value = "")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
    }

    @DeleteMapping(value ="")
    public void deleteUser(){
        userService.deleteAllUsers();
    }

}
