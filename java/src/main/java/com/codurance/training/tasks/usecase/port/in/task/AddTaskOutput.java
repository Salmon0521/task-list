package com.codurance.training.tasks.usecase.port.in.task;

import com.codurance.training.tasks.usecase.port.in.UseCaseOutput;

public class AddTaskOutput implements UseCaseOutput {
    private String errorMessage;

    public AddTaskOutput() {
        this.errorMessage = "";
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
