package com.codurance.training.tasks.command;

import com.codurance.training.tasks.Task;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Add implements Command {
    private static long lastId = 0;

    @Override
    public void execute(String commandLine, Map<String, List<Task>> tasks, PrintWriter out) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        addType(subcommandRest[1], tasks, out);
    }

    private void addType(String commandLine, Map<String, List<Task>> tasks, PrintWriter out) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1], tasks);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectTask[0], projectTask[1], tasks, out);
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
        projectTasks.add(new Task(nextId(), description, false));
    }

    public static long nextId() {
        return ++lastId;
    }

}
