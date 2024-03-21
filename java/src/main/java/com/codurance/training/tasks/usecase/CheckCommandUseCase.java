package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.TaskList;

public class CheckCommandUseCase implements CommandUseCase {
    private final boolean check;
    private final Integer id;

    public CheckCommandUseCase(String idString, boolean check) {
        this.id = Integer.parseInt(idString);
        this.check = check;
    }

    @Override
    public String execute(String commandLine) {
        TaskList taskList = TaskList.getInstance();
        if (! taskList.setTaskDone(id, check)) {
            return String.format("Could not find a task with an ID of %d.", id) + System.lineSeparator();
        }
        return null;
    }

}
