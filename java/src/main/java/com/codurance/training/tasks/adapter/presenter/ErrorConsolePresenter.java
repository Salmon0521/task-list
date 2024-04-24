package com.codurance.training.tasks.adapter.presenter;

import com.codurance.training.tasks.io.Output;
import com.codurance.training.tasks.usecase.port.out.todolist.error.ErrorPresenter;

public class ErrorConsolePresenter implements ErrorPresenter {
    private final Output out;

    public ErrorConsolePresenter(Output out) {
        this.out = out;
    }

    @Override
    public void present(String errorMessage) {
       out.print(errorMessage);
    }
}
