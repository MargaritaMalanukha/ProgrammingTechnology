package com.tasks5.command;

public class Application3 {

    public static void main(String[] args) {
        Command command;

        if (args == null || args.length == 0) {
            System.out.println("Error");
        } else if (args[0].equals("help") && args.length == 1) {
            command = new HelpCommand();
            command.execute();
        } else if (args[0].equals("echo") && args.length == 2) {
            command = new EchoCommand(args[1]);
            command.execute();
        } else if (args[0].equals("date") && args[1].equals("now") && args.length == 2) {
            command = new DateCommand();
            command.execute();
        } else if (args[0].equals("exit") && args.length == 1) {
            command = new ExitCommand();
            command.execute();
        } else {
            System.out.println("Error");
        }

    }

}
