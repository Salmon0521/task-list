package com.codurance.training.tasks.adapter;

import com.codurance.training.tasks.adapter.controller.*;

public class ControllerFactory {
    private ControllerFactory() {
    }

    public static Controller createController(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                return new ShowController();
            case "add":
                String[] subCommandRest = commandRest[1].split(" ", 2);
                String subCommand = subCommandRest[0];
                if (subCommand.equals("task")) {
                    return new AddTaskController();
                } else if (subCommand.equals("project")) {
                    return new AddProjectController();
                }
            case "check":
                return new CheckController();
            case "uncheck":
                return new UnCheckController();
            case "help":
                return new HelpController();
            default:
                return new ErrorController();
        }
    }
}
