package com.codurance.training.tasks.command;

import com.codurance.training.tasks.tasklist.TaskList;

public class Error implements Command {
    private final String commandline;

    public Error(String commandline) {
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
