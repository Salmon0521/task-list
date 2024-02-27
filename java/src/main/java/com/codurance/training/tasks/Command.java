package com.codurance.training.tasks;

public class Command {
    private final String command;
    private final String rest;

    public Command(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        command = commandRest[0];
        rest = commandRest.length > 1 ? commandRest[1] : "";
    }

    public String getCommand() {
        return command;
    }

    public String getRest() {
        return rest;
    }
}
