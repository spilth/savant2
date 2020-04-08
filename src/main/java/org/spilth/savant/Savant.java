package org.spilth.savant;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

public class Savant {
    public static void main(String[] args) {
        CommandMain commandMain = new CommandMain();
        InitializeCommand initializeCommand = new InitializeCommand();

        JCommander jCommander = JCommander.newBuilder()
                .programName("savant")
                .addObject(commandMain)
                .addCommand("init", initializeCommand)
                .build();

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
