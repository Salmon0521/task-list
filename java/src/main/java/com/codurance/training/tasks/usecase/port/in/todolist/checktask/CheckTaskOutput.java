package com.codurance.training.tasks.usecase.port.in.todolist.checktask;

import com.codurance.training.tasks.usecase.port.in.UseCaseOutput;

public class CheckTaskOutput implements UseCaseOutput {
    private String errorMessage;

    public CheckTaskOutput() {
        this.errorMessage = "";
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
