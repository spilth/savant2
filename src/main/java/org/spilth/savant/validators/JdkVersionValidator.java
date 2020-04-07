package org.spilth.savant.validators;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import java.util.List;

import static java.util.Arrays.asList;

public class JdkVersionValidator implements IParameterValidator {
    public static final List<String> VERSIONS = asList("1.8", "1.9", "1.10", "11", "12", "13", "14");

    @Override
    public void validate(String name, String value) throws ParameterException {
        if (!VERSIONS.contains(value)) {
            throw new ParameterException("JDK Version must be one of: 1.8, 1.9, 1.10, 11, 12, 13, 14");
        }
    }
}
