package com.application.redis.resource;


import com.application.redis.entity.User;
import com.application.redis.repository.UserRepository;
import com.application.redis.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserResource {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok(this.userService.saveUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(this.userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") long id){
        return ResponseEntity.ok(this.userService.findById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteById(@PathVariable("id") long id){
        return ResponseEntity.ok(this.userService.findById(id));
    }

}
