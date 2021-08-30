import java.util.Objects;
import java.util.Scanner;

public class Duke {
    public static String concatenateChar(String line, String start, String end) {
        int indexOfStart = line.indexOf(start) + 1;
        int indexOfEnd = 0;
        if (end == null) {
            indexOfEnd = line.length();
        } else {
            indexOfEnd = line.indexOf(end);
        }
        String taskName = line.substring(indexOfStart, indexOfEnd);
        return taskName;
    }

    public static void main(String[] args) {
        String logo = " _           _        \n"
                + "| |    _   _| | _____ \n"
                + "| |   | | | | |/ / _ \\\n"
                + "| |_  | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Luke");
        System.out.println("What can I do for you?");
        Task[] taskList = new Task[100];
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        while (!line.equals("bye")) {
            if (line.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int taskNo = 0; taskNo < Task.getNoOfTasks(); taskNo++) {
                    System.out.println((taskNo + 1) + ". " + taskList[taskNo]);
                }
            }

            if (line.contains("todo")) {
                String toDoName = concatenateChar(line, " ", null);
                taskList[Task.getNoOfTasks()] = new ToDos(toDoName);
                taskList[Task.getNoOfTasks() - 1].taskIcon = "T";
                System.out.println("Got it! I have added this task:");
                System.out.println(taskList[Task.getNoOfTasks() - 1]);
                System.out.println("Now you have " + Task.getNoOfTasks() + " tasks in your list");
            }
            if (line.contains("deadline")) {
                String deadlineName = concatenateChar(line, " ", "/");
                String date = concatenateChar(line, "/", null);
                taskList[Task.getNoOfTasks()] = new Deadline(deadlineName, date);
                taskList[Task.getNoOfTasks() - 1].taskIcon = "D";
                System.out.println("Got it! I have added this task:");
                System.out.println(taskList[Task.getNoOfTasks() - 1]);
                System.out.println("Now you have " + Task.getNoOfTasks() + " tasks in your list");
            }
            if (line.contains("event")) {
                String eventName = concatenateChar(line, " ", "/");
                String duration = concatenateChar(line, "/", null);
                taskList[Task.getNoOfTasks()] = new Event(eventName, duration);
                taskList[Task.getNoOfTasks() - 1].taskIcon = "E";
                System.out.println("Got it! I have added this task:");
                System.out.println(taskList[Task.getNoOfTasks() - 1]);
                System.out.println("Now you have " + Task.getNoOfTasks() + " tasks in your list");
            }

            if (line.contains("done")) {
                String taskNo = concatenateChar(line, " ", null);
                int taskNoComplete = Integer.parseInt(taskNo) - 1;
                taskList[taskNoComplete].markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(" [X] " + taskList[taskNoComplete].description);
            }
            line = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
