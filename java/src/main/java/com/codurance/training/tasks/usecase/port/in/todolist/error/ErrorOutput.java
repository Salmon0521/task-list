package com.codurance.training.tasks.usecase.port.in.todolist.error;

import com.codurance.training.tasks.usecase.port.in.UseCaseOutput;

public class ErrorOutput implements UseCaseOutput {
    private final String errorMessage;

    public ErrorOutput(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
