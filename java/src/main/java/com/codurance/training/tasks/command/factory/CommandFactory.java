package com.codurance.training.tasks.command.factory;

import com.codurance.training.tasks.command.AddCommand;
import com.codurance.training.tasks.command.CheckCommand;
import com.codurance.training.tasks.command.HelpCommand;
import com.codurance.training.tasks.command.ShowCommand;
import com.codurance.training.tasks.command.Command;
import com.codurance.training.tasks.command.ErrorCommand;

public class CommandFactory {

    public Command createCommand(String commandline) {
        String[] commandRest = commandline.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                return new ShowCommand();
            case "add":
                return new AddCommand(commandRest[1]);
            case "check":
            case "uncheck":
                return new CheckCommand(command, commandRest[1]);
            case "help":
                return new HelpCommand();
            default:
                return new ErrorCommand(command);
        }
    }
}
