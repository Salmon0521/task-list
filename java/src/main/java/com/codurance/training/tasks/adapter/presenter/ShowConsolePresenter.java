package com.codurance.training.tasks.adapter.presenter;

import com.codurance.training.tasks.io.Output;
import com.codurance.training.tasks.usecase.port.in.todolist.show.ProjectDto;
import com.codurance.training.tasks.usecase.port.in.todolist.show.TaskDto;
import com.codurance.training.tasks.usecase.port.in.todolist.show.ToDoListDto;
import com.codurance.training.tasks.usecase.port.out.todolist.show.ShowPresenter;

public class ShowConsolePresenter implements ShowPresenter {

        private final Output out;

        public ShowConsolePresenter(Output out) {
            this.out = out;
        }

        @Override
        public void present(ToDoListDto toDoListDto) {
            StringBuilder result = new StringBuilder();
            for (ProjectDto project : toDoListDto.getProjectDtos())
            {
                result.append(project.getName()).append(System.lineSeparator());
                for (TaskDto task : project.getTaskDtos()) {
                    String msg = String.format("    [%c] %s: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
                    result.append(msg);
                }
                result.append(System.lineSeparator());
            }
            out.print(result.toString());
        }
}
