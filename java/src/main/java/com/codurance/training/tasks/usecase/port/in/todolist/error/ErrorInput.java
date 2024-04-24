package com.codurance.training.tasks.usecase.port.in.todolist.error;

import com.codurance.training.tasks.usecase.port.in.UseCaseInput;

public class ErrorInput implements UseCaseInput {
    private final String errorMessage;

    public ErrorInput(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
