package duke;

import duke.customexception.IllegalInputException;
import java.util.Scanner;

public class Duke {
    public static void printLineSeparator() {
        System.out.println("---------------------" +
                "---------------------" +
                "---------------------" +
                "---------------------" +
                "---------------------" +
                "---------------------" +
                "---------------------" +
                "---------------------");
    }

    public static void printGreetings() {
        String LOGO = " _           _        \n"
                + "| |    _   _| | _____ \n"
                + "| |   | | | | |/ / _ \\\n"
                + "| |_  | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + LOGO);
        System.out.println("Hello! I'm Luke");
        System.out.println("What can I do for you?");
        printLineSeparator();
    }

    public static boolean isTask(String line) throws IllegalInputException {
        if (!(line.startsWith("todo") || line.startsWith("event") || line.startsWith("deadline"))) {
            throw new IllegalInputException();
        }
        return true;
    }

    public static void main(String[] args) {
        printGreetings();
        TaskManager list = new TaskManager();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while (!line.equals("bye")) {
            printLineSeparator();
            try {
                if (line.equals("list")) {
                    list.printList();
                } else if (line.startsWith("done")) {
                    list.checkOffTask(line);
                } else if (isTask(line)) {
                    list.addTask(line);
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Invalid task! Try again");
            } catch (IllegalInputException e) {
                System.out.println("Invalid command! Try again");
            } catch (NumberFormatException e) {
                System.out.println("Please input task number completed");
            }
            printLineSeparator();
            line = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}

