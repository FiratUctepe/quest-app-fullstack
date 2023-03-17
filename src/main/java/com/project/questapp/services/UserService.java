package com.project.questapp.services;

import com.project.questapp.entities.User;
import com.project.questapp.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    public User createUser(User newUser){
        return userRepository.save(newUser);
    }


    public User getOneUser(Long userId){
        return userRepository.findById(userId).orElse(null);
    }


    public void deleteOneUser(Long userId){
        userRepository.deleteById(userId);
    }
    public User updateOneUser(Long userId,User newUser){
        User user = userRepository.findById(userId).get();

        if(user != null){

            user.setUserName(newUser.getUserName());
            user.setPassword(newUser.getPassword());
            user.setAvatar(newUser.getAvatar());

            userRepository.save(user);
            return user;
        }else
        return null;
    }

}
