package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.entity.TaskList;

public class CheckCommand implements Command {
    protected boolean check;
    private final Integer id;

    public CheckCommand(String command, String idString) {
        this.id = Integer.parseInt(idString);
        if (command.equals("check")) {
            this.check = true;
        } else {
            this.check = false;
        }
    }

    @Override
    public String execute() {
        return taskCheck(TaskList.getInstance());
    }

    private String taskCheck(TaskList taskList) {
        if (! taskList.setTaskDone(id, check)) {
            return String.format("Could not find a task with an ID of %d.", id) + System.lineSeparator();
        }
        return null;
    }
}
