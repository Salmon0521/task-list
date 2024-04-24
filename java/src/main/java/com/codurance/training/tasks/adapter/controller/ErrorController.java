package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.ErrorConsolePresenter;
import com.codurance.training.tasks.entity.ToDoList;
import com.codurance.training.tasks.io.Output;
import com.codurance.training.tasks.usecase.port.in.todolist.error.ErrorInput;
import com.codurance.training.tasks.usecase.port.in.todolist.error.ErrorOutput;
import com.codurance.training.tasks.usecase.service.ErrorService;

public class ErrorController implements Controller{
    @Override
    public String execute(ToDoList toDoList, String commandLine, Output out) {
        ErrorService errorService = new ErrorService();
        ErrorInput input = new ErrorInput(commandLine);
        ErrorOutput errorOutput = errorService.execute(input);
        ErrorConsolePresenter presenter = new ErrorConsolePresenter(out);
        presenter.present(errorOutput.getErrorMessage());
        return "";
    }
}
