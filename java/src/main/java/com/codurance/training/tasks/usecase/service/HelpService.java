package com.codurance.training.tasks.usecase.service;

import com.codurance.training.tasks.usecase.port.in.UseCaseInput;
import com.codurance.training.tasks.usecase.port.in.todolist.help.HelpDto;
import com.codurance.training.tasks.usecase.port.in.todolist.help.HelpOutput;
import com.codurance.training.tasks.usecase.port.in.todolist.help.HelpUseCase;

public class HelpService implements HelpUseCase {
    public HelpService() {}

    @Override
    public HelpOutput execute(UseCaseInput.NullInput input) {
        HelpDto helpDto = new HelpDto();
        helpDto.heading = "Commands:";
        helpDto.commands.add("show");
        helpDto.commands.add("add project <project name>");
        helpDto.commands.add("add task <project name> <task description>");
        helpDto.commands.add("check <task ID>");
        helpDto.commands.add("uncheck <task ID>");

        HelpOutput output = HelpOutput.create();
        output.setHelpDto(helpDto);
        return output;
    }
}
