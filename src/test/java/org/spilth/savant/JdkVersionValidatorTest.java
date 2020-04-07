package org.spilth.savant;

import com.beust.jcommander.ParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spilth.savant.validators.JdkVersionValidator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JdkVersionValidatorTest {
    private JdkVersionValidator jdkVersionValidator;

    @BeforeEach
    void setUp() {
        jdkVersionValidator = new JdkVersionValidator();
    }

    @Test
    void validateDoesNotThrowException() {
        assertDoesNotThrow(() -> jdkVersionValidator.validate("jdkVersion", "1.10"));
    }

    @Test
    void validateThrowsException() {
        Exception exception = assertThrows(ParameterException.class, () -> jdkVersionValidator.validate("jdkVersion", "42"));
        assertEquals("JDK Version must be one of: 1.8, 1.9, 1.10, 11, 12, 13, 14", exception.getMessage());
    }
}
