package com.example.auth.utils;

import com.example.auth.models.ResponseUser;
import com.example.auth.models.User;

import java.util.List;
import java.util.stream.Collectors;

public class Helper {
    public static List<ResponseUser> convertToResponseUsers(List<User> users) {
        return users.stream().map(Helper::convertToResponseUser).collect(Collectors.toList());
    }

    public static ResponseUser convertToResponseUser(User user) {
        ResponseUser responseUser = new ResponseUser();
        responseUser.setName(user.getName());
        responseUser.setEmail(user.getEmail());
        responseUser.setUsername(user.getUsername());
        responseUser.setPhoneNumber(user.getPhoneNumber());
        responseUser.setRole(user.getRole());
        return responseUser;
    }
}
