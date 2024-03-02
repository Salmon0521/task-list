package com.codurance.training.tasks.command;

import com.codurance.training.tasks.tasklist.Task;
import com.codurance.training.tasks.tasklist.TaskList;

import java.util.List;

public class AddCommand implements Command {
    private final String type;
    private final String commandline;

    public AddCommand(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        this.type = command;
        this.commandline = commandRest[1];
    }

    @Override
    public String execute(TaskList taskList) {
        return add(taskList);
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
