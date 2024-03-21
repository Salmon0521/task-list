package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.usecase.CheckCommandUseCase;
import com.codurance.training.tasks.usecase.CommandUseCase;

public class UnCheckController implements Controller{
    @Override
    public String execute(String commandLine) {
        String[] args = commandLine.split(" ", 2);
        CommandUseCase checkCommandUseCase = new CheckCommandUseCase(args[1], false);
        return checkCommandUseCase.execute(commandLine);
    }
}
