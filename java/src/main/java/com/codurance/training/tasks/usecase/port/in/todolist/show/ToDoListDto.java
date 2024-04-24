package com.codurance.training.tasks.usecase.port.in.todolist.show;

import java.util.ArrayList;
import java.util.List;

public class ToDoListDto {
    private String id;
    private List<ProjectDto> projectDtos;
    public ToDoListDto() {
        this.projectDtos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ProjectDto> getProjectDtos() {
        return projectDtos;
    }

    public void setProjectDtos(List<ProjectDto> projectDtos) {
        this.projectDtos = projectDtos;
    }
}
