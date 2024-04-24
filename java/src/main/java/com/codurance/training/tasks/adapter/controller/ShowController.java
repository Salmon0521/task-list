package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.ShowConsolePresenter;
import com.codurance.training.tasks.entity.ToDoList;
import com.codurance.training.tasks.io.Output;
import com.codurance.training.tasks.usecase.port.in.todolist.show.ShowInput;
import com.codurance.training.tasks.usecase.port.in.todolist.show.ShowOutput;
import com.codurance.training.tasks.usecase.service.ShowService;

public class ShowController implements Controller{
    @Override
    public String execute(ToDoList toDoList, String commandLine, Output out) {
        ShowService showService = new ShowService(toDoList);
        ShowInput input = new ShowInput();
        ShowOutput showOutput = showService.execute(input);
        ShowConsolePresenter presenter = new ShowConsolePresenter(out);
        presenter.present(showOutput.getToDoListDto());
        return "";
    }
}
