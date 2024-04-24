package com.codurance.training.tasks.usecase;


import com.codurance.training.tasks.entity.ToDoList;

public interface CommandUseCase {

    String execute(ToDoList toDoList, String commandLine);
}
