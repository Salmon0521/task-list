package com.codurance.training.tasks.command;

import com.codurance.training.tasks.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class Check implements Command {
    protected boolean checked;
    private final Integer id;

    public Check(String command, String idString) {
        this.id = Integer.parseInt(idString);
        if (command.equals("check")) {
            this.checked = true;
        } else {
            this.checked = false;
        }
    }

    @Override
    public void execute(Map<String, List<Task>> tasks, PrintWriter out) {
        setDone(checked, tasks, out);
    }

    private void setDone(boolean done, Map<String, List<Task>> tasks, PrintWriter out) {
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
