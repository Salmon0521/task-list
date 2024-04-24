package com.codurance.training.tasks.usecase.service;

import com.codurance.training.tasks.entity.TaskId;
import com.codurance.training.tasks.entity.ToDoList;
import com.codurance.training.tasks.usecase.port.in.todolist.checktask.CheckTaskInput;
import com.codurance.training.tasks.usecase.port.in.todolist.checktask.CheckTaskOutput;
import com.codurance.training.tasks.usecase.port.in.todolist.checktask.CheckTaskUseCase;

public class CheckTaskService implements CheckTaskUseCase {
    private final ToDoList toDoList;

    public CheckTaskService(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    @Override
    public CheckTaskOutput execute(CheckTaskInput input) {
        CheckTaskOutput output = new CheckTaskOutput();
        if (! toDoList.setTaskDone(TaskId.of(input.getId()), input.isDone())) {
            String errMsg = String.format("Could not find a task with an ID of %s.", input.getId()) + System.lineSeparator();
            output.setErrorMessage(errMsg);
        }
        return output;
    }
}
