package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.usecase.CommandUseCase;
import com.codurance.training.tasks.usecase.ShowCommandUseCase;

public class ShowController implements Controller{
    @Override
    public String execute(String commandLine) {
        CommandUseCase showCommandUseCase = new ShowCommandUseCase();
        return showCommandUseCase.execute("");
    }
}
