package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.entity.TaskList;

public class ShowCommand implements Command {
    @Override
    public String execute(TaskList taskList) {
        return show(taskList);
    }

    private String show(TaskList taskList) {
        return taskList.toString();
    }
}
