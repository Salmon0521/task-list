package com.codurance.training.tasks.operator;

import com.codurance.training.tasks.Command;
import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.Utiliy;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Add implements Operator {

    @Override
    public void execute(String commandLine, Map<String, List<Task>> tasks, PrintWriter out) {
        Command command = new Command(commandLine);
        addType(command.getRest(), tasks, out);
    }

    private void addType(String commandLine, Map<String, List<Task>> tasks, PrintWriter out) {
        Command command = new Command(commandLine);
        if (command.getCommand().equals("project")) {
            addProject(command.getRest(), tasks);
        } else if (command.getCommand().equals("task")) {
            Command subcommand = new Command(command.getRest());
            addTask(subcommand.getCommand(), subcommand.getRest(), tasks, out);
        }
    }

    private void addProject(String name, Map<String, List<Task>> tasks) {
        tasks.put(name, new ArrayList<Task>());
    }

    private void addTask(String project, String description, Map<String, List<Task>> tasks, PrintWriter out) {
        List<Task> projectTasks = tasks.get(project);
        if (projectTasks == null) {
            out.printf("Could not find a project with the name \"%s\".", project);
            out.println();
            return;
        }
        projectTasks.add(new Task(Utiliy.nextId(), description, false));
    }


}
