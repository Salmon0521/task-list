package com.codurance.training.tasks.command;

import com.codurance.training.tasks.tasklist.TaskList;

public class Help implements Command {
    @Override
    public String execute(TaskList taskList) {
        return help();
    }

    private String help() {
        return "Commands:" +
                System.lineSeparator() +
                "  show" +
                System.lineSeparator() +
                "  add project <project name>" +
                System.lineSeparator() +
                "  add task <project name> <task description>" +
                System.lineSeparator() +
                "  check <task ID>" +
                System.lineSeparator() +
                "  uncheck <task ID>" +
                System.lineSeparator() +
                System.lineSeparator();
    }

}
