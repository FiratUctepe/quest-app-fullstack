package com.project.questapp.services;

import com.project.questapp.entities.User;
import com.project.questapp.repos.UserRepository;
import com.project.questapp.requests.UserCreateRequest;
import com.project.questapp.requests.UserUpdateRequest;
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


    public User createUser(UserCreateRequest newUser){
        User user = new User();

        user.setUserName(newUser.getUserName());
        user.setPassword(newUser.getPassword());
        user.setAvatar(newUser.getAvatar());

        return userRepository.save(user);
    }


    public User getOneUserById(Long userId){
        return userRepository.findById(userId).orElse(null);
    }


    public void deleteOneUser(Long userId){
        userRepository.deleteById(userId);
    }
    public User updateOneUser(Long userId, UserUpdateRequest newUser){
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

    public User getOneUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public void saveOneUser(User user){
        userRepository.save(user);
    }
}
