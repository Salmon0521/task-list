package com.codurance.training.tasks.usecase;

public class ErrorCommandUseCase implements CommandUseCase {
    public ErrorCommandUseCase() {}

    @Override
    public String execute(String commandline) {
        return String.format("I don't know what the command \"%s\" is.", commandline) + System.lineSeparator();
    }

}
