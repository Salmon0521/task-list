package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.ToDoList;

public class ErrorCommandUseCase implements CommandUseCase {
    public ErrorCommandUseCase() {}

    @Override
    public String execute(ToDoList toDoList, String commandline) {
        return String.format("I don't know what the command \"%s\" is.", commandline) + System.lineSeparator();
    }

}
