package com.project.questapp.services;

import com.project.questapp.entities.User;
import com.project.questapp.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    public UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
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
