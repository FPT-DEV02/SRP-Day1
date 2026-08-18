package com.userregistration.model;

import lombok.Data;

@Data
public class UserRegistrationRequest {
    private final String email;
    private final String password;
}
