package com.application.redis.repository;


import com.application.redis.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {

    public static final String HASH_KEY = "User";
    private final RedisTemplate redisTemplate;


    public User saveUser(User user){
        this.redisTemplate.opsForHash().put(HASH_KEY,user.getId(),user);
        return user;
    }

    public List<User> findAll(){
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public User findById(long id){
        return (User) redisTemplate.opsForHash().get(HASH_KEY,id);
    }

    public boolean deleteById(long id){
        this.redisTemplate.opsForHash().delete(HASH_KEY,id);
        return true;
    }



}
