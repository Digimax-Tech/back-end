package com.sipress.apiRest.controller;


import com.sipress.apiRest.models.User;
import com.sipress.apiRest.repository.UserRepository;
import lombok.val;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll() ;
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


    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user) {
        return userRepository.findById(id).map(user1 -> {
            user1.setEmail(user.getEmail());
            user1.setNom(user.getNom());
            user1.setNumTel(user.getNumTel());
            user1.setPrenom(user.getPrenom());
            user1.setPassword(user.getPassword());
            return userRepository.save(user1);
        }).orElseThrow(() -> new ResourceNotFoundException("Userid " + id + " not found"));
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Userid " + id + " not found"));
    }


}
