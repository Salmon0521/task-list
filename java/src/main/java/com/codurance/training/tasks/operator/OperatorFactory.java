package com.codurance.training.tasks.operator;

public class OperatorFactory {
    public Operator createOperator(String operatorName) {
        switch (operatorName) {
            case "show":
                return new com.codurance.training.tasks.operator.ShowTask();
            case "add":
                return new com.codurance.training.tasks.operator.Add();
            case "check":
                return new com.codurance.training.tasks.operator.CheckTask();
            case "uncheck":
                return new com.codurance.training.tasks.operator.UncheckTask();
            case "help":
                return new com.codurance.training.tasks.operator.Help();
            default:
                return new com.codurance.training.tasks.operator.Error();
        }
    }
}
