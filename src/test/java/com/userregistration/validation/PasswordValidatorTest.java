package com.userregistration.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordValidatorTest {
    private final PasswordValidator validator = new PasswordValidator();

    @Test
    void shouldAcceptStrongPassword() {
        assertDoesNotThrow(() -> validator.validate("Password@123"));
    }

    @Test
    void shouldRejectShortPassword() {
        assertThrows(ValidationException.class, () -> validator.validate("Ab1@"));
    }

    @Test
    void shouldRejectPasswordWithoutSpecialCharacter() {
        assertThrows(ValidationException.class, () -> validator.validate("Password123"));
    }
}
