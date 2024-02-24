package com.example.auth.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUser {
    private String name;
    private String email;
    private String username;
    private String phoneNumber;
    private String role;
}
