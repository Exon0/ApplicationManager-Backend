package tn.neopolis.ApplicationManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.neopolis.ApplicationManager.exceptions.UserNotFoundException;
import tn.neopolis.ApplicationManager.models.User;
import tn.neopolis.ApplicationManager.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) throws UserNotFoundException {

        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user){
        return userRepository.save(user);

    }
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
}
