package com.codurance.training.tasks.usecase.port.in.todolist.help;

import com.codurance.training.tasks.usecase.port.in.UseCaseOutput;

public class HelpOutput implements UseCaseOutput {
    public HelpDto helpDto;
    public static HelpOutput create(){
        return new HelpOutput();
    }

    public HelpDto getHelpDto() {
        return helpDto;
    }

    public void setHelpDto(HelpDto helpDto) {
        this.helpDto = helpDto;
    }
}
