package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.entity.ToDoList;
import com.codurance.training.tasks.io.Output;
import com.codurance.training.tasks.usecase.port.in.UseCase;
import com.codurance.training.tasks.usecase.port.in.project.AddProjectInput;
import com.codurance.training.tasks.usecase.service.AddProjectService;

public class AddProjectController implements Controller {
    @Override
    public String execute(ToDoList toDoList, String commandLine, Output out) {
        String[] args = commandLine.split(" ", 3);
        UseCase addProjectService = new AddProjectService(toDoList);
        AddProjectInput input = new AddProjectInput(args[2]);
        addProjectService.execute(input);
        return "";
    }
}
