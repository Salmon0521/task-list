package com.codurance.training.tasks.usecase.service;

import com.codurance.training.tasks.entity.ProjectName;
import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.ToDoList;
import com.codurance.training.tasks.usecase.port.in.task.AddTaskInput;
import com.codurance.training.tasks.usecase.port.in.task.AddTaskOutput;
import com.codurance.training.tasks.usecase.port.in.task.AddTaskUseCase;

import java.util.List;

public class AddTaskService implements AddTaskUseCase {
    private final ToDoList toDoList;

    public AddTaskService(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    @Override
    public AddTaskOutput execute(AddTaskInput input) {
        List<Task> projectTasks = toDoList.getTasks(ProjectName.of(input.getProjectName()));
        AddTaskOutput output = new AddTaskOutput();
        if (projectTasks == null) {
            String errMsg = String.format("Could not find a project with the name \"%s\".", input.getProjectName()) + System.lineSeparator();
            output.setErrorMessage(errMsg);
            return output;
        }
        toDoList.addTask(ProjectName.of(input.getProjectName()), input.getDescription());
        return output;
    }
}
