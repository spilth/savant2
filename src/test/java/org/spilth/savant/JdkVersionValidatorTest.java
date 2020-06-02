package org.spilth.savant;

import com.beust.jcommander.ParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.spilth.savant.validators.JdkVersionValidator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class JdkVersionValidatorTest {
    private JdkVersionValidator jdkVersionValidator;

    @BeforeEach
    void setUp() {
        jdkVersionValidator = new JdkVersionValidator();
    }

    @Nested
    class Validate {
        @Test
        void whenVersionIsValid() {
            assertThatCode(() -> jdkVersionValidator.validate("jdkVersion", "1.10"))
                    .doesNotThrowAnyException();
        }

        @Test
        void whenVersionIsInvalid() {
            assertThatExceptionOfType(ParameterException.class)
                    .isThrownBy(() -> jdkVersionValidator.validate("jdkVersion", "42"))
                    .withMessage("JDK Version must be one of: 1.8, 1.9, 1.10, 11, 12, 13, 14");
        }
    }
}
