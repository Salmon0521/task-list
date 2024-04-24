package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.Project;
import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.ToDoList;

import java.util.List;
import java.util.Map;

public class ShowCommandUseCase implements CommandUseCase {
    @Override
    public String execute(ToDoList toDoList, String commandLine) {
        List<Project> projects = toDoList.getProjects();
        StringBuilder result = new StringBuilder();
        for (Project project : projects) {
            result.append(project.getName().toString()).append(System.lineSeparator());
            for (Task task : project.getTasks()) {
                String msg = String.format("    [%c] %s: %s%n", (task.isDone() ? 'x' : ' '), task.getId().toString(), task.getDescription());
                result.append(msg);
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }
}
