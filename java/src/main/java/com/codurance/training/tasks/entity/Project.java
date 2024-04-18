package com.codurance.training.tasks.entity;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private ProjectName name;
    private List<Task> tasks;

    public Project(ProjectName name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public ProjectName getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
