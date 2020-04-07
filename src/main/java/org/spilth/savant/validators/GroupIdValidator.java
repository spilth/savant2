package org.spilth.savant.validators;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class GroupIdValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        if (!value.matches("[\\w-.]+")) {
            throw new ParameterException("Group ID must contain only lowercase letters, dashes and periods");
        }
    }
}
