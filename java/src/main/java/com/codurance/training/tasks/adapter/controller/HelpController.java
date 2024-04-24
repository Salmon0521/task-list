package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.entity.ToDoList;
import com.codurance.training.tasks.usecase.CommandUseCase;
import com.codurance.training.tasks.usecase.HelpCommandUseCase;

public class HelpController implements Controller{
    @Override
    public String execute(ToDoList toDoList, String commandLine) {
        CommandUseCase helpCommandUseCase = new HelpCommandUseCase();
        return helpCommandUseCase.execute(toDoList, "");
    }
}
