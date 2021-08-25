import java.util.Objects;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " _           _        \n"
                + "| |    _   _| | _____ \n"
                + "| |   | | | | |/ / _ \\\n"
                + "| |_  | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Luke");
        System.out.println("What can I do for you?");
        Task[] list = new Task[100];
        Scanner in = new Scanner(System.in);
        String line;
        line = in.nextLine();
        int noOfTasks = 0;
        while (!line.equals("bye")) {
            if (line.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < noOfTasks; i++) {
                    System.out.println((i + 1) + ". " + "[" + list[i].getStatusIcon() + "]" + list[i].description);
                }
                noOfTasks -= 1;
            }
            if (!line.equals("list") && !(line.contains("done"))) {
                list[noOfTasks] = new Task(line);
                System.out.println("added: " + line);
            }
            if (line.contains("done")) {
                int a = line.indexOf(" ");
                String taskNo = line.substring(a + 1);
                int taskNoComplete = Integer.parseInt(taskNo) - 1;
                list[taskNoComplete].markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(" [X] " + list[taskNoComplete].description);
                noOfTasks -= 1;
            }
            line = in.nextLine();
            noOfTasks++;
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
