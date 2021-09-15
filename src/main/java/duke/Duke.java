package duke;

import duke.customexception.IllegalInputException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

    public static void main(String[] args) throws IOException {
        printGreetings();
        TaskManager list = new TaskManager();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        File taskFile = createFile();
        readFile(list, taskFile);
        while (!line.equals("bye")) {
            printLineSeparator();
            try {
                if (line.equals("list")) {
                    list.printList();
                } else if (line.startsWith("done")) {
                    list.checkOffTask(line);
                } else if (line.startsWith("delete")) {
                    list.deleteTask(line);
                } else if (isTask(line)) {
                    list.addTask(line);
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Invalid task! Try again");
            } catch (IllegalInputException e) {
                System.out.println("Invalid command! Try again");
            } catch (NumberFormatException e) {
                System.out.println("Please input task number in command");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please input correct task number");
            }
            printLineSeparator();
            line = in.nextLine();
        }
        writeFile(taskFile, list);
        System.out.println("Bye. Hope to see you again soon!");
    }

    private static void writeFile(File taskFile, TaskManager list) throws IOException {
        FileWriter writeToFile = new FileWriter(taskFile);
        for (int i = 0; i < list.getSize(); i++) {
            writeToFile.write(list.getTask(i) + "\n");
        }
        writeToFile.close();
    }

    private static void readFile(TaskManager list, File file) throws FileNotFoundException {
        Scanner s = new Scanner(file);
        int taskNo = 0;
        while (s.hasNext()) {
            String[] textSegment = s.nextLine().split(";");
            if (textSegment[0].equals("duke.tasktype.ToDo")) {
                list.addTask("todo " + textSegment[2]);
                if (textSegment[1].equals("true")) {
                    list.markDone(taskNo);
                }
            } else if (textSegment[0].equals("duke.tasktype.Event")) {
                list.addTask("event " + textSegment[2] + "/" + textSegment[3]);
                if (textSegment[1].equals("true")) {
                    list.markDone(taskNo);
                }
            } else {
                list.addTask("deadline " + textSegment[2] + "/" + textSegment[3]);
                if (textSegment[1].equals("true")) {
                    list.markDone(taskNo);
                }
            }
            taskNo++;
        }
    }

    private static File createFile() throws IOException {
        File file = new File("data/duke.txt");
        if (!file.exists()) {
            File dir = new File("data");
            dir.mkdir();
            File newFile = new File("data/duke.txt");
            newFile.createNewFile();
            return newFile;
        }
        return file;
    }
}


