package com.codurance.training.tasks.command;

import com.codurance.training.tasks.tasklist.TaskList;

public interface Command {

    String execute(TaskList tasks);
}
