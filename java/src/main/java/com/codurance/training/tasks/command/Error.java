package com.codurance.training.tasks.command;

import com.codurance.training.tasks.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class Error implements Command {
    @Override
    public void execute(String command, Map<String, List<Task>> tasks, PrintWriter out) {
        error(command, out);
    }

    private void error(String command, PrintWriter out) {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }

}
