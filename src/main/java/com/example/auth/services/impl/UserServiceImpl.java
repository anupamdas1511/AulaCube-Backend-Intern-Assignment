package com.example.auth.services.impl;

import com.example.auth.models.User;
import com.example.auth.services.UserService;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserServiceImpl implements UserService {
    private final Map<String, User> inMemoryUserRepository = new HashMap<>();

    @Override
    public User createUser(User user) throws Exception {
        if (inMemoryUserRepository.containsKey(user.getUsername())) {
            throw new Exception("Username Already Exists");
        }
        inMemoryUserRepository.put(user.getUsername(), user);
        return user;
    }

    @Override
    public User updateUser(String username, User updatedUser) {
        if (inMemoryUserRepository.containsKey(username)) {
            updatedUser.setUsername(username);
            updatedUser.setRole("USER");
            inMemoryUserRepository.put(username, updatedUser);
            return updatedUser;
        } else {
            throw new IllegalArgumentException("User not found with username: " + username);
        }
    }

    @Override
    public void deleteUser(String username) {
        inMemoryUserRepository.remove(username);
    }

    @Override
    public User getUserById(String username) {
        return Optional.ofNullable(inMemoryUserRepository.get(username))
                .orElseThrow(() -> new IllegalArgumentException("User not found with username: " + username));
    }

    @Override
    public User getUserByEmail(String email) {
        return inMemoryUserRepository.values().stream()
                .filter(user -> email.equals(user.getEmail()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + email));
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(inMemoryUserRepository.values());
    }
}
