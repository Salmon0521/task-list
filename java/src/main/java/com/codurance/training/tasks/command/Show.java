package com.codurance.training.tasks.command;

import com.codurance.training.tasks.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class Show implements Command {
    @Override
    public void execute(Map<String, List<Task>> tasks, PrintWriter out) {
        show(tasks, out);
    }

    private void show(Map<String, List<Task>> tasks, PrintWriter out) {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            out.println(project.getKey());
            for (Task task : project.getValue()) {
                out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            out.println();
        }
    }
}
