package com.codurance.training.tasks.command.factory;

import com.codurance.training.tasks.command.*;
import com.codurance.training.tasks.command.Error;

public class CommandFactory {
    public Command createOperator(String operatorName) {
        switch (operatorName) {
            case "show":
                return new Show();
            case "add":
                return new Add();
            case "check":
            case "uncheck":
                return new Check(operatorName);
            case "help":
                return new Help();
            default:
                return new Error();
        }
    }
}
