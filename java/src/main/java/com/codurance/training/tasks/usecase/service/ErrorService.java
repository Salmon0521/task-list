package com.codurance.training.tasks.usecase.service;

import com.codurance.training.tasks.usecase.port.in.todolist.error.ErrorInput;
import com.codurance.training.tasks.usecase.port.in.todolist.error.ErrorOutput;
import com.codurance.training.tasks.usecase.port.in.todolist.error.ErrorUseCase;

public class ErrorService implements ErrorUseCase {
    @Override
    public ErrorOutput execute(ErrorInput input) {
        ErrorOutput errorOutput = new ErrorOutput(input.getErrorMessage());
        return errorOutput;
    }
}
