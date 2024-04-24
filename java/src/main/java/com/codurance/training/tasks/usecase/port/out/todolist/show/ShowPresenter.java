package com.codurance.training.tasks.usecase.port.out.todolist.show;

import com.codurance.training.tasks.usecase.port.in.todolist.show.ToDoListDto;

public interface ShowPresenter {
    void present(ToDoListDto toDoListDto);
}
