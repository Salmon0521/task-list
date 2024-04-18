package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.ProjectName;
import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.ToDoList;

import java.util.List;

public class AddCommandUseCase implements CommandUseCase {
    private final String type;
    private final String commandline;

    public AddCommandUseCase(String type, String commandLine) {
        this.type = type;
        this.commandline = commandLine;
    }

    @Override
    public String execute(String commandLine) {
        return add(ToDoList.getInstance());
    }

    private String add(ToDoList toDoList) {
        if (type.equals("project")) {
            addProject(commandline, toDoList);
        } else if (type.equals("task")) {
            String[] projectTask = commandline.split(" ", 2);
            return addTask(projectTask[0], projectTask[1], toDoList);
        }
        return null;
    }

    private void addProject(String projectName, ToDoList toDoList) {
        toDoList.addProject(ProjectName.of(projectName));
    }

    private String addTask(String project, String description, ToDoList toDoList) {
        List<Task> projectTasks = toDoList.getProject(ProjectName.of(project));
        if (projectTasks == null) {
            return String.format("Could not find a project with the name \"%s\".", project) + System.lineSeparator();
        }
        toDoList.addTask(ProjectName.of(project), description);
        return null;
    }

}
