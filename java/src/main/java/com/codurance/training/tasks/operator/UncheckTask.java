package com.codurance.training.tasks.operator;

import com.codurance.training.tasks.Command;
import com.codurance.training.tasks.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class UncheckTask implements Operator{
    @Override
    public void execute(String commandline, Map<String, List<Task>> tasks, PrintWriter out) {
        Command command = new Command(commandline);
        setDone(command.getRest(), false, tasks, out);
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
