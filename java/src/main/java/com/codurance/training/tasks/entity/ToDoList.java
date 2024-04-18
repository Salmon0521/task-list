package com.codurance.training.tasks.entity;

import java.util.*;

public class ToDoList {
    private static long lastId = 0;
    private final List<Project> projects = new LinkedList<>();
    private static ToDoList instance;

    private ToDoList() {}

    public static ToDoList getInstance() {
        if (instance == null) {
            instance = new ToDoList();
        }
        return instance;
    }


    public Map<String, List<Task>> getTasks() {
        Map<String, List<Task>> tasks = new LinkedHashMap<>();
        for (Project project : projects) {
            tasks.put(project.getName().toString(), project.getTasks());
        }
        return tasks;
    }

    public List<Task> getProject(ProjectName projectName) {
        Project project = projects.stream().filter(p -> p.getName().equals(projectName)).findFirst().orElse(null);
        return project != null ? project.getTasks() : null;
    }

    public void addProject(ProjectName projectName) {
        if (projects.stream().noneMatch(p -> p.getName().equals(projectName))) {
            projects.add(new Project(projectName));
        }
    }

    public void addTask(ProjectName projectName, String description) {
        Task task = new Task(TaskId.of(nextId()), description, false);
        for (Project project : projects) {
            if (project.getName().equals(projectName)) {
                project.addTask(task);
                return;
            }
        }
    }

    public Boolean setTaskDone(TaskId taskId, boolean check) {
        for (Project project : projects) {
            for (Task task : project.getTasks()) {
                if (task.getId().equals(taskId)) {
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
