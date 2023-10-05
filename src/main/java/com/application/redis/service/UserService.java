package com.application.redis.service;


import com.application.redis.entity.User;
import com.application.redis.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user){
        return this.userRepository.saveUser(user);
    }

    public List<User> findAll(){
        return  this.userRepository.findAll();
    }

    public User findById(long id){
        return this.userRepository.findById(id);
    }

    public boolean deleteUserById(long id){
        return this.userRepository.deleteById(id);
    }


}
