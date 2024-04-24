package com.codurance.training.tasks.adapter.presenter;

import com.codurance.training.tasks.io.Output;
import com.codurance.training.tasks.usecase.port.in.todolist.help.HelpDto;
import com.codurance.training.tasks.usecase.port.out.todolist.help.HelpPresenter;

public class HelpConsolePresenter implements HelpPresenter {
    private final Output out;

    public HelpConsolePresenter(Output out) {
        this.out = out;
    }

    @Override
    public void present(HelpDto helpDto) {
        out.print(helpDto.heading + System.lineSeparator());
        for(var command : helpDto.commands)
            out.print(String.format("  %s" + System.lineSeparator(), command));
        out.print(System.lineSeparator());
    }
}
