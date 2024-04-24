package com.codurance.training.tasks.usecase.port.in.task;

import com.codurance.training.tasks.usecase.port.in.UseCaseInput;

public class AddTaskInput implements UseCaseInput {
    private String projectName;
    private String description;

    public AddTaskInput(String projectName, String description) {
        this.projectName = projectName;
        this.description = description;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getDescription() {
        return description;
    }
}
