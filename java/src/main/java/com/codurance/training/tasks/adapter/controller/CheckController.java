package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.usecase.CheckCommandUseCase;
import com.codurance.training.tasks.usecase.CommandUseCase;

public class CheckController implements Controller{
    @Override
    public String execute(String commandLine) {
        String[] args = commandLine.split(" ", 2);
        CommandUseCase checkCommandUseCase = new CheckCommandUseCase(args[1], true);
        return checkCommandUseCase.execute(commandLine);
    }
}
