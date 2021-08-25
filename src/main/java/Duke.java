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
        String[] list = new String[100];
        Scanner in = new Scanner(System.in);
        String line;
        line = in.nextLine();
        int noOfBooks = 0;
        while (!Objects.equals(line, "bye")) {
            if (Objects.equals(line, "list")) {
                for (int i = 0; i < noOfBooks; i++) {
                    System.out.println((i + 1) + ": " + list[i]);
                }
            }
            list[noOfBooks] = line;
            if (!Objects.equals(line, "list")) {
                System.out.println("added: " + line);
            }
            line = in.nextLine();
            noOfBooks++;
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
