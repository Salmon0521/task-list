package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.HelpConsolePresenter;
import com.codurance.training.tasks.entity.ToDoList;
import com.codurance.training.tasks.io.Output;
import com.codurance.training.tasks.usecase.port.in.UseCaseInput;
import com.codurance.training.tasks.usecase.port.in.todolist.help.HelpOutput;
import com.codurance.training.tasks.usecase.service.HelpService;

public class HelpController implements Controller{
    @Override
    public void execute(ToDoList toDoList, String commandLine, Output out) {
        HelpService helpService = new HelpService();
        HelpOutput output = helpService.execute(new UseCaseInput.NullInput());
        HelpConsolePresenter presenter = new HelpConsolePresenter(out);
        presenter.present(output.getHelpDto());
    }
}
