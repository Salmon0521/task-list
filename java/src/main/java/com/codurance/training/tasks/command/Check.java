package com.codurance.training.tasks.command;

import com.codurance.training.tasks.tasklist.TaskList;

public class Check implements Command {
    protected boolean check;
    private final Integer id;

    public Check(String command, String idString) {
        this.id = Integer.parseInt(idString);
        if (command.equals("check")) {
            this.check = true;
        } else {
            this.check = false;
        }
    }

    @Override
    public String execute(TaskList tasks) {
        return taskCheck(tasks);
    }

    private String taskCheck(TaskList taskList) {
        if (! taskList.setTaskDone(id, check)) {
            return String.format("Could not find a task with an ID of %d.", id) + System.lineSeparator();
        }
        return null;
    }
}
