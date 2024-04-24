package com.codurance.training.tasks.entity;

import tw.teddysoft.ezddd.core.entity.AggregateRoot;
import tw.teddysoft.ezddd.core.entity.DomainEvent;

import java.util.*;

public class ToDoList extends AggregateRoot<ToDoListId, DomainEvent> {

    private final ToDoListId id;
    private final List<Project> projects;

    private static long lastId = 0;

    public ToDoList(ToDoListId id) {
        this.id = id;
        this.projects  = new LinkedList<>();
    }

    @Override
    public ToDoListId getId() {
        return id;
    }

    public List<Project> getProjects() {
        return projects.stream()
                .map(project -> (Project)new ReadOnlyProject(project.getName(), project.getTasks()))
                .toList();
    }

    public List<Task> getTasks(ProjectName projectName) {
        Project project = projects.stream()
                .filter(p -> p.getName().equals(projectName))
                .findFirst()
                .orElse(null);
        if (project == null) {
            return null;
        }

        return project.getTasks().stream()
                .map(task -> (Task)new ReadOnlyTask(task.getId(), task.getDescription(), task.isDone()))
                .toList();
    }

    public void addProject(ProjectName projectName) {
        if (projects.stream().noneMatch(p -> p.getName().equals(projectName))) {
            projects.add(new Project(projectName, new ArrayList<>()));
        }
    }

    public void addTask(ProjectName projectName, String description) {
        for (Project project : projects) {
            if (project.getName().equals(projectName)) {
                project.addTask(TaskId.of(nextId()), description, false);
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
