package org.spilth.savant;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

public class Savant {
    public static void main(String[] args) {
        JCommander jCommander = new JCommander();
        jCommander.setProgramName("savant");

        InitializeCommand initializeCommand = new InitializeCommand();
        jCommander.addCommand(initializeCommand);

        try {
            jCommander.parse(args);
        } catch (ParameterException parameterException) {
            System.out.println(parameterException.getMessage());
            System.exit(1);
        }

        if (jCommander.getParsedCommand() == null) {
            jCommander.usage();
        } else {
            if (jCommander.getParsedCommand().equals("init")) {
                new InitializeService(initializeCommand);
            }
        }
    }
}
