package com.example.auth.services;

import com.example.auth.models.User;

import java.util.List;

public interface UserService {
    User createUser(User user) throws Exception;
    User updateUser(String username, User user);
    void deleteUser(String username);
    User getUserById(String username);
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
