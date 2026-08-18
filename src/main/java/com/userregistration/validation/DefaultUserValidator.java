package com.userregistration.validation;

public class DefaultUserValidator implements UserValidator {
    private final EmailValidator emailValidator;
    private final PasswordValidator passwordValidator;

    public DefaultUserValidator(EmailValidator emailValidator, PasswordValidator passwordValidator) {
        this.emailValidator = emailValidator;
        this.passwordValidator = passwordValidator;
    }

    @Override
    public void validate(String email, String password) {
        emailValidator.validate(email);
        passwordValidator.validate(password);
    }
}
