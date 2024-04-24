package com.codurance.training.tasks.usecase.port.in.todolist.show;

import java.util.List;

public class ProjectDto {
    private String name;
    private List<TaskDto> taskDtos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskDto> getTaskDtos() {
        return taskDtos;
    }

    public void setTaskDtos(List<TaskDto> taskDtos) {
        this.taskDtos = taskDtos;
    }

}
