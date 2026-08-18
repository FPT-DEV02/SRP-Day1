package com.userregistration.validation;

public class PasswordValidator {
    public void validate(String password) {
        if (password == null || password.isBlank()) {
            throw new ValidationException("Password must not be blank");
        }

        if (password.length() < 8) {
            throw new ValidationException("Password must be at least 8 characters");
        }

        if (!password.chars().anyMatch(Character::isUpperCase)) {
            throw new ValidationException("Password must contain an uppercase letter");
        }

        if (!password.chars().anyMatch(Character::isLowerCase)) {
            throw new ValidationException("Password must contain a lowercase letter");
        }

        if (!password.chars().anyMatch(Character::isDigit)) {
            throw new ValidationException("Password must contain a digit");
        }

        if (password.chars().noneMatch(ch -> !Character.isLetterOrDigit(ch))) {
            throw new ValidationException("Password must contain a special character");
        }
    }
}
