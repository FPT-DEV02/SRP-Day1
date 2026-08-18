package com.userregistration.service;

import com.userregistration.email.WelcomeEmailSender;
import com.userregistration.hashing.PasswordHasher;
import com.userregistration.model.User;
import com.userregistration.repository.UserRepository;
import com.userregistration.validation.UserValidator;

public class UserRegistrationService {
    private final UserValidator userValidator;
    private final PasswordHasher passwordHasher;
    private final UserRepository userRepository;
    private final WelcomeEmailSender welcomeEmailSender;

    public UserRegistrationService(UserValidator userValidator,
                                   PasswordHasher passwordHasher,
                                   UserRepository userRepository,
                                   WelcomeEmailSender welcomeEmailSender) {
        this.userValidator = userValidator;
        this.passwordHasher = passwordHasher;
        this.userRepository = userRepository;
        this.welcomeEmailSender = welcomeEmailSender;
    }

    public User register(String email, String rawPassword) {
        userValidator.validate(email, rawPassword);

        String hashedPassword = passwordHasher.hash(rawPassword);
        User user = new User(email, hashedPassword);
        User savedUser = userRepository.save(user);

        welcomeEmailSender.sendWelcomeEmail(savedUser);
        return savedUser;
    }
}
