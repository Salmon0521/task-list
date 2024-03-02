package com.codurance.training.tasks.command.factory;

import com.codurance.training.tasks.command.Add;
import com.codurance.training.tasks.command.Check;
import com.codurance.training.tasks.command.Help;
import com.codurance.training.tasks.command.Show;
import com.codurance.training.tasks.command.Command;
import com.codurance.training.tasks.command.Error;

public class CommandFactory {

    public Command createCommand(String commandline) {
        String[] commandRest = commandline.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                return new Show();
            case "add":
                return new Add(commandRest[1]);
            case "check":
            case "uncheck":
                return new Check(command, commandRest[1]);
            case "help":
                return new Help();
            default:
                return new Error(command);
        }
    }
}
