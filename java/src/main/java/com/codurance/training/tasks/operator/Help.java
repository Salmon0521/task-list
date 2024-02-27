package com.codurance.training.tasks.operator;

import com.codurance.training.tasks.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class Help implements Operator {
    @Override
    public void execute(String command, Map<String, List<Task>> tasks, PrintWriter out) {
        help(out);
    }

    private void help(PrintWriter out) {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println();
    }
}
