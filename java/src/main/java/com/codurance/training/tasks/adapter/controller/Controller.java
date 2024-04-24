package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.entity.ToDoList;
import com.codurance.training.tasks.io.Output;

public interface Controller {
    void execute(ToDoList toDoList, String commandLine, Output out);
}
