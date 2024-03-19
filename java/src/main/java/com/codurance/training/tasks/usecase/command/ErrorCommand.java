package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.entity.TaskList;

public class ErrorCommand implements Command {
    private final String commandline;

    public ErrorCommand(String commandline) {
        this.commandline = commandline;
    }

    @Override
    public String execute(TaskList taskList) {
        return error();
    }

    private String error() {
        return String.format("I don't know what the command \"%s\" is.", commandline) + System.lineSeparator();
    }

}
