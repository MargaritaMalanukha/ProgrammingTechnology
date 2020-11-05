package com.tasks5.command;

public class EchoCommand implements Command {

    private final String message;

    public EchoCommand(String message) {
        this.message = message;
    }

    @Override
    public void execute() {
        System.out.println(message);
    }
}
