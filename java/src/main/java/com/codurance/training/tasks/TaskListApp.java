package com.codurance.training.tasks;

import com.codurance.training.tasks.command.Command;
import com.codurance.training.tasks.command.factory.CommandFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public final class TaskListApp implements Runnable {
    private static final String QUIT = "quit";

    private final TaskList taskList = new TaskList();
    private final CommandFactory commandFactory = new CommandFactory();
    private final BufferedReader in;
    private final PrintWriter out;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskListApp(in, out).run();
    }

    public TaskListApp(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
    }

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String commandline;
            try {
                commandline = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (commandline.equals(QUIT)) {
                break;
            }
            String[] commandRest = commandline.split(" ", 2);
            String command = commandRest[0];
            Command command1 = commandFactory.createOperator(command);
            command1.execute(commandline, taskList.getTasks(), out);
        }
    }

}
