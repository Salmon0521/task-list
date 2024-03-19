package com.codurance.training.tasks.entity;

import java.util.*;

public class TaskList {
    private static long lastId = 0;
    private final List<Project> projects = new LinkedList<>();

    public Map<String, List<Task>> getTasks() {
        Map<String, List<Task>> tasks = new LinkedHashMap<>();
        for (Project project : projects) {
            tasks.put(project.getName(), project.getTasks());
        }
        return tasks;
    }

    public List<Task> getProject(String projectName) {
        Project project = projects.stream().filter(p -> p.getName().equals(projectName)).findFirst().orElse(null);
        return project != null ? project.getTasks() : null;
    }

    public void addProject(String projectName) {
        if (projects.stream().noneMatch(p -> p.getName().equals(projectName))) {
            projects.add(new Project(projectName));
        }
    }

    public void addTask(String projectName, String description) {
        Task task = new Task(nextId(), description, false);
        for (Project project : projects) {
            if (project.getName().equals(projectName)) {
                project.addTask(task);
                return;
            }
        }
    }

    public Boolean setTaskDone(int taskId, boolean check) {
        for (Project project : projects) {
            for (Task task : project.getTasks()) {
                if (task.getId() == taskId) {
                    task.setDone(check);
                    return true;
                }
            }
        }
        return false;
    }

    private static long nextId() {
        return ++lastId;
    }
}
