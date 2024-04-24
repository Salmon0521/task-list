package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.ErrorConsolePresenter;
import com.codurance.training.tasks.entity.ToDoList;
import com.codurance.training.tasks.io.Output;
import com.codurance.training.tasks.usecase.port.in.task.AddTaskInput;
import com.codurance.training.tasks.usecase.port.in.task.AddTaskOutput;
import com.codurance.training.tasks.usecase.service.AddTaskService;

public class AddTaskController implements Controller{
    @Override
    public String execute(ToDoList toDoList, String commandLine, Output out) {
        String[] args = commandLine.split(" ", 4);
        AddTaskService addTaskService = new AddTaskService(toDoList);
        AddTaskInput input = new AddTaskInput(args[2], args[3]);
        AddTaskOutput addTaskOutput = addTaskService.execute(input);
        ErrorConsolePresenter presenter = new ErrorConsolePresenter(out);
        presenter.present(addTaskOutput.getErrorMessage());
        return null;
    }
}
