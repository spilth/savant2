package org.spilth.savant;

import com.beust.jcommander.ParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spilth.savant.validators.GroupIdValidator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GroupIdValidatorTest {
    private GroupIdValidator groupIdValidator;

    @BeforeEach
    void setUp() {
        groupIdValidator = new GroupIdValidator();
    }

    @Test
    void validateDoesNotThrowException() {
        assertDoesNotThrow(() -> groupIdValidator.validate("groupId", "com.example"));
    }

    @Test
    void validateThrowsException() {
        Exception exception = assertThrows(ParameterException.class, () -> groupIdValidator.validate("groupId", "com example"));
        assertEquals("Group ID must contain only lowercase letters, dashes and periods", exception.getMessage());
    }
}
