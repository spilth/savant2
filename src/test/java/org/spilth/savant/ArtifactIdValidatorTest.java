package org.spilth.savant;

import com.beust.jcommander.ParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spilth.savant.validators.ArtifactIdValidator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArtifactIdValidatorTest {
    private ArtifactIdValidator validator;

    @BeforeEach
    void setUp() {
        validator = new ArtifactIdValidator();
    }

    @Test
    void validateDoesNotThrowException() {
        assertDoesNotThrow(() -> validator.validate("artifactId", "hello-world"));
    }

    @Test
    void validateThrowsException() {
        Exception exception = assertThrows(ParameterException.class, () -> validator.validate("artifactId", "hello world"));
        assertEquals("Artifact ID must contain only lowercase letters and dashes", exception.getMessage());
    }
}
