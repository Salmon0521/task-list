package com.codurance.training.tasks.command;

import com.codurance.training.tasks.tasklist.TaskList;

public class Show implements Command {
    @Override
    public String execute(TaskList taskList) {
        return show(taskList);
    }

    private String show(TaskList taskList) {
        return taskList.toString();
    }
}
