package org.spilth.savant;

import com.beust.jcommander.ParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.spilth.savant.validators.GroupIdValidator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GroupIdValidatorTest {
    private GroupIdValidator groupIdValidator;

    @BeforeEach
    void setUp() {
        groupIdValidator = new GroupIdValidator();
    }

    @Nested
    class Validate {
        @Test
        void whenGroupIdIsValid() {
            assertThatCode(() -> groupIdValidator.validate("groupId", "com.example"))
                    .doesNotThrowAnyException();
        }

        @Test
        void whenGroupIdIsInvalid() {
            assertThatExceptionOfType(ParameterException.class)
                    .isThrownBy(() -> groupIdValidator.validate("groupId", "com example"))
                    .withMessage("Group ID must contain only lowercase letters, dashes and periods");
        }
    }

}
