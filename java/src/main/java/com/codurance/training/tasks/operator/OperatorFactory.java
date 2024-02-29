package com.codurance.training.tasks.operator;

public class OperatorFactory {
    public Operator createOperator(String operatorName) {
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
