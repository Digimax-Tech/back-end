package com.sipress.apiRest.controller;


import com.sipress.apiRest.models.User;
import com.sipress.apiRest.repository.UserRepository;
import lombok.val;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public User Register(@RequestBody User user) {
        return userRepository.save(user);
    }
    @PostMapping("/login")
    public User Login(@RequestBody User user) {
        val oldUSer = userRepository.findByEmailAndPassword(user.email, user.password);
        return oldUSer;
    }


}
