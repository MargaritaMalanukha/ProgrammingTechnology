package com.tasks5.command;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Exit");
    }
}
