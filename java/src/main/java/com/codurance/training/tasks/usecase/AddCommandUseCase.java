package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;

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
        return add(TaskList.getInstance());
    }

    private String add(TaskList taskList) {
        if (type.equals("project")) {
            addProject(commandline, taskList);
        } else if (type.equals("task")) {
            String[] projectTask = commandline.split(" ", 2);
            return addTask(projectTask[0], projectTask[1], taskList);
        }
        return null;
    }

    private void addProject(String name, TaskList taskList) {
        taskList.addProject(name);
    }

    private String addTask(String project, String description, TaskList taskList) {
        List<Task> projectTasks = taskList.getProject(project);
        if (projectTasks == null) {
            return String.format("Could not find a project with the name \"%s\".", project) + System.lineSeparator();
        }
        taskList.addTask(project, description);
        return null;
    }

}
