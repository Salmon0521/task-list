package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.ErrorConsolePresenter;
import com.codurance.training.tasks.entity.ToDoList;
import com.codurance.training.tasks.io.Output;
import com.codurance.training.tasks.usecase.port.in.todolist.checktask.CheckTaskInput;
import com.codurance.training.tasks.usecase.port.in.todolist.checktask.CheckTaskOutput;
import com.codurance.training.tasks.usecase.service.CheckTaskService;

public class CheckController implements Controller{
    @Override
    public void execute(ToDoList toDoList, String commandLine, Output out) {
        String[] args = commandLine.split(" ", 2);
        CheckTaskService checkTaskService = new CheckTaskService(toDoList);
        CheckTaskInput input = new CheckTaskInput(args[1], true);
        CheckTaskOutput output = checkTaskService.execute(input);
        ErrorConsolePresenter presenter = new ErrorConsolePresenter(out);
        presenter.present(output.getErrorMessage());
    }
}
