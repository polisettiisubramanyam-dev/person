package com.practice.person.controller;

import com.practice.person.entity.UserEntity;
import com.practice.person.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/create")
    public String create(@RequestBody UserEntity user) {
        return service.create(user);
    }

    @GetMapping("/find/{id}")
    public UserEntity findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PutMapping("/update/{id}")
    public UserEntity update(@PathVariable int id,
                             @RequestBody UserEntity user) {
        return service.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id) {
        return service.deleteById(id);
    }
}
