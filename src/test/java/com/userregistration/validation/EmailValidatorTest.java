package com.userregistration.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailValidatorTest {
    private final EmailValidator validator = new EmailValidator();

    @Test
    void shouldAcceptValidEmail() {
        assertDoesNotThrow(() -> validator.validate("user@example.com"));
    }

    @Test
    void shouldRejectBlankEmail() {
        assertThrows(ValidationException.class, () -> validator.validate(" "));
    }

    @Test
    void shouldRejectInvalidEmailFormat() {
        assertThrows(ValidationException.class, () -> validator.validate("invalid-email"));
    }
}
