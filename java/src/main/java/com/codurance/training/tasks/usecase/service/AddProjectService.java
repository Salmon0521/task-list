package com.codurance.training.tasks.usecase.service;

import com.codurance.training.tasks.entity.ProjectName;
import com.codurance.training.tasks.entity.ToDoList;
import com.codurance.training.tasks.usecase.port.in.project.AddProjectInput;
import com.codurance.training.tasks.usecase.port.in.project.AddProjectUseCase;
import com.codurance.training.tasks.usecase.port.in.project.AddProjectOutput;

public class AddProjectService implements AddProjectUseCase {

    private final ToDoList toDoList;

    public AddProjectService(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    @Override
    public AddProjectOutput execute(AddProjectInput input) {
        toDoList.addProject(ProjectName.of(input.getProjectName()));
        return new AddProjectOutput();
    }
}
