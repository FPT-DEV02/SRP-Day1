package com.userregistration;

import com.userregistration.email.ConsoleWelcomeEmailSender;
import com.userregistration.hashing.PasswordHasher;
import com.userregistration.hashing.Sha256PasswordHasher;
import com.userregistration.repository.InMemoryUserRepository;
import com.userregistration.repository.UserRepository;
import com.userregistration.service.UserRegistrationService;
import com.userregistration.validation.DefaultUserValidator;
import com.userregistration.validation.EmailValidator;
import com.userregistration.validation.PasswordValidator;

public class Main {
    public static void main(String[] args) {
        EmailValidator emailValidator = new EmailValidator();
        PasswordValidator passwordValidator = new PasswordValidator();
        PasswordHasher passwordHasher = new Sha256PasswordHasher();
        UserRepository userRepository = new InMemoryUserRepository();

        UserRegistrationService userRegistrationService = new UserRegistrationService(
                new DefaultUserValidator(emailValidator, passwordValidator),
                passwordHasher,
                userRepository,
                new ConsoleWelcomeEmailSender()
        );

        userRegistrationService.register("demo@example.com", "Password@123");
    }
}
