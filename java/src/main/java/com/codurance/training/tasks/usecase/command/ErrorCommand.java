package com.codurance.training.tasks.usecase.command;

public class ErrorCommand implements Command {
    private final String commandline;

    public ErrorCommand(String commandline) {
        this.commandline = commandline;
    }

    @Override
    public String execute() {
        return String.format("I don't know what the command \"%s\" is.", commandline) + System.lineSeparator();
    }

}
