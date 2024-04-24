package com.codurance.training.tasks.usecase.service;

import com.codurance.training.tasks.entity.ToDoList;
import com.codurance.training.tasks.usecase.port.in.todolist.show.ShowInput;
import com.codurance.training.tasks.usecase.port.in.todolist.show.ShowOutput;
import com.codurance.training.tasks.usecase.port.in.todolist.show.ShowUseCase;
import com.codurance.training.tasks.usecase.port.ToDoListMapper;

public class ShowService implements ShowUseCase {
    private final ToDoList toDoList;
    public ShowService(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    @Override
    public ShowOutput execute(ShowInput input) {
        ShowOutput output = new ShowOutput();
        output.setToDoListDto(ToDoListMapper.toDto(toDoList));
        return output;
    }
}
