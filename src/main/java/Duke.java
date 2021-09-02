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

    public static void main(String[] args) {
        printGreetings();
        TaskList list = new TaskList();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while (!line.equals("bye")) {
            printLineSeparator();
            if (line.equals("list")) {
                list.printTaskList();
            } else if (line.startsWith("done")) {
                list.checkOffTask(line);
            } else {
                list.addTask(line);
            }
            printLineSeparator();
            line = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
