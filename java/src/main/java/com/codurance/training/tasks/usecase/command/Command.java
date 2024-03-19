package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.entity.TaskList;

public interface Command {

    String execute(TaskList tasks);
}
