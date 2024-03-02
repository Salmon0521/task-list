package com.codurance.training.tasks.command;

import com.codurance.training.tasks.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class Check implements Command {
    protected boolean checked;

    public Check(String operatorName) {
        if (operatorName.equals("check")) {
            this.checked = true;
        } else {
            this.checked = false;
        }
    }

    @Override
    public void execute(String commandLine, Map<String, List<Task>> tasks, PrintWriter out) {
        String[] commandRest = commandLine.split(" ", 2);
        setDone(commandRest[1], checked, tasks, out);
    }

    private void setDone(String idString, boolean done, Map<String, List<Task>> tasks, PrintWriter out) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
}
