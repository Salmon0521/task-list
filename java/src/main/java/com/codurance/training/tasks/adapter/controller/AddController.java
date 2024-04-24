package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.entity.ToDoList;
import com.codurance.training.tasks.usecase.AddCommandUseCase;
import com.codurance.training.tasks.usecase.CommandUseCase;

public class AddController implements Controller{
    @Override
    public String execute(ToDoList toDoList, String commandLine) {
        String[] args = commandLine.split(" ", 3);
        CommandUseCase addCommandUseCase = new AddCommandUseCase(args[1], args[2]);
        return addCommandUseCase.execute(toDoList, commandLine);
    }
}
