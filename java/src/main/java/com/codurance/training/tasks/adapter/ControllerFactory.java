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
                return new AddController();
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
