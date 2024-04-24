package com.codurance.training.tasks.usecase.port.in.todolist.show;

import com.codurance.training.tasks.usecase.port.in.UseCaseOutput;

public class ShowOutput implements UseCaseOutput {
    private ToDoListDto toDoListDto;

    public ToDoListDto getToDoListDto() {
        return toDoListDto;
    }

    public void setToDoListDto(ToDoListDto toDoListDto) {
        this.toDoListDto = toDoListDto;
    }
}
