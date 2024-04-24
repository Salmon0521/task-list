package com.codurance.training.tasks.usecase.port.in.todolist.checktask;

import com.codurance.training.tasks.usecase.port.in.UseCaseInput;

public class CheckTaskInput implements UseCaseInput {
    private String id;
    private boolean isDone;

    public CheckTaskInput(String id, boolean isDone) {
        this.id = id;
        this.isDone = isDone;
    }

    public String getId() {
        return id;
    }

    public boolean isDone() {
        return isDone;
    }

}
