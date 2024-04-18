package com.codurance.training.tasks.io;

import com.codurance.training.tasks.adapter.ControllerFactory;
import com.codurance.training.tasks.adapter.controller.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public final class TaskListApp implements Runnable {
    private static final String QUIT = "quit";
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
        Controller controller = ControllerFactory.createController(commandline);
        String errMsg = controller.execute(commandline);
        if (errMsg != null) {
            output.print(errMsg);
        }
    }

}
