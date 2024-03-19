package com.codurance.training.tasks;

import com.codurance.training.tasks.io.Input;
import com.codurance.training.tasks.io.Output;
import com.codurance.training.tasks.usecase.command.Command;
import com.codurance.training.tasks.usecase.CommandFactory;
import com.codurance.training.tasks.entity.TaskList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public final class TaskListApp implements Runnable {
    private static final String QUIT = "quit";

    private final TaskList taskList = new TaskList();
    private final CommandFactory commandFactory = new CommandFactory();
    private final Input input;
    private final Output output;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskListApp(in, out).run();
    }

    public TaskListApp(BufferedReader reader, PrintWriter writer) {
        this.input = new Input(reader);
        this.output = new Output(writer);
    }

    public void run() {
        while (true) {
            output.prompt();
            String command = input.readLine();
            if (command.equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }

    private void execute(String commandline){
        Command command = commandFactory.createCommand(commandline);
        String errMsg = command.execute(taskList);
        if (errMsg != null) {
            output.print(errMsg);
        }
    }

}
