package com.codurance.training.tasks.entity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TaskList {
    private static long lastId = 0;
    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();

    public Map<String, List<Task>> getTasks() {
        return tasks;
    }

    public List<Task> getProject(String project) {
        return tasks.get(project);
    }

    public void addProject(String project) {
        tasks.put(project, new java.util.ArrayList<>());
    }

    public void addTask(String project, String description) {
        Task task = new Task(nextId(), description, false);
        tasks.get(project).add(task);
    }

    public Boolean setTaskDone(int taskId, boolean check) {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == taskId) {
                    task.setDone(check);
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            result.append(project.getKey()).append(System.lineSeparator());
            for (Task task : project.getValue()) {
                String msg = String.format("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
                result.append(msg);
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }

    private static long nextId() {
        return ++lastId;
    }
}
