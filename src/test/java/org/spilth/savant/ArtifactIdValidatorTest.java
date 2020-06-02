package org.spilth.savant;

import com.beust.jcommander.ParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.spilth.savant.validators.ArtifactIdValidator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ArtifactIdValidatorTest {
    private ArtifactIdValidator validator;

    @BeforeEach
    void setUp() {
        validator = new ArtifactIdValidator();
    }

    @Nested
    class Validate {
        @Test
        void whenArtifactIdIsValid() {
            assertThatCode(() -> validator.validate("artifactId", "hello-world"))
                    .doesNotThrowAnyException();
        }

        @Test
        void whenArtifactIdIsInvalid() {
            assertThatExceptionOfType(ParameterException.class)
                    .isThrownBy(() -> validator.validate("artifactId", "hello world"))
                    .withMessage("Artifact ID must contain only lowercase letters and dashes");
        }
    }
}
