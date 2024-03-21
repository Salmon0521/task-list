package com.codurance.training.tasks.usecase;


public class HelpCommandUseCase implements CommandUseCase {
    @Override
    public String execute(String commandLine) {
        return "Commands:" +
                System.lineSeparator() +
                "  show" +
                System.lineSeparator() +
                "  add project <project name>" +
                System.lineSeparator() +
                "  add task <project name> <task description>" +
                System.lineSeparator() +
                "  check <task ID>" +
                System.lineSeparator() +
                "  uncheck <task ID>" +
                System.lineSeparator() +
                System.lineSeparator();
    }

}
