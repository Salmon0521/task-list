package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.entity.ToDoList;
import com.codurance.training.tasks.usecase.CommandUseCase;
import com.codurance.training.tasks.usecase.ErrorCommandUseCase;

public class ErrorController implements Controller{
    @Override
    public String execute(ToDoList toDoList, String commandLine) {
        CommandUseCase errorCommandUseCase = new ErrorCommandUseCase();
        return errorCommandUseCase.execute(toDoList, commandLine);
    }
}
