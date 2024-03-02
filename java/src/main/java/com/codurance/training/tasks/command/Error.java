package com.codurance.training.tasks.command;

import com.codurance.training.tasks.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class Error implements Command {
    private final String commandline;

    public Error(String commandline) {
        this.commandline = commandline;
    }

    @Override
    public void execute(Map<String, List<Task>> tasks, PrintWriter out) {
        error(out);
    }

    private void error(PrintWriter out) {
        out.printf("I don't know what the command \"%s\" is.", commandline);
        out.println();
    }

}
