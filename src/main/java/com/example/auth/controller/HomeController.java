package com.example.auth.controller;

import com.example.auth.models.User;
import com.example.auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    // API: http://localhost:8081/home/users
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    // API: http://localhost:8081/home/add-user
    @PostMapping("/add-user")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        user.setRole("USER");
        try {
            userService.createUser(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    // API: http://localhost:8081/home/remove-user
    @DeleteMapping("/remove-user")
    public ResponseEntity<?> removeUser(@RequestBody String username) {
        try {
            userService.deleteUser(username);
            return ResponseEntity.ok("User removed");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    // API: http://localhost:8081/home/edit-user
    @PatchMapping("/edit-user")
    public ResponseEntity<?> editUser(@RequestParam String username, @RequestBody User user) {
        try {
            userService.updateUser(username, user);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
