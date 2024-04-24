package com.codurance.training.tasks.usecase.port.in.project;

import com.codurance.training.tasks.usecase.port.in.UseCaseInput;

public class AddProjectInput implements UseCaseInput {
    private String projectName;

    public AddProjectInput(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }
}
