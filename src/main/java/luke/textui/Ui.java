package luke.textui;

import luke.Task;
import luke.TaskList;

import java.util.Scanner;

import static luke.common.Messages.LINE_SEPARATOR;
import static luke.common.Messages.WELCOME_MESSAGE;
import static luke.common.Messages.GOODBYE_MESSAGE;
import static luke.common.Messages.FILE_ERROR_MESSAGE;
import static luke.common.Messages.TASK_ADDED_MESSAGE;
import static luke.common.Messages.TASK_LIST_MESSAGE;
import static luke.common.Messages.TASK_DELETED_MESSAGE;
import static luke.common.Messages.TASK_COMPLETED_MESSAGE;
import static luke.common.Messages.EMPTY_TASK_LIST_MESSAGE;
import static luke.common.Messages.INVALID_SEARCH_MESSAGE;

/**
 * This class is the user interface of the program.
 * It takes in user input and displays the corresponding information on the command line.
 */
public class Ui {
    private final Scanner scanner;

    /**
     * Initializes the user interface
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showLineSeparator() {
        System.out.println(LINE_SEPARATOR);
    }

    public void showWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void showGoodbyeMessage() {
        System.out.println(GOODBYE_MESSAGE);
    }

    public void showFileErrorMessage() {
        System.out.println(FILE_ERROR_MESSAGE);
    }

    public void showTaskAddedMessage(Task task, TaskList tasks) {
        System.out.println(TASK_ADDED_MESSAGE);
        System.out.println(task);
        System.out.println("Now you have " + tasks.getSize() + " tasks in your list.");
    }

    public void showTaskCompletedMessage(Task task) {
        System.out.println(TASK_COMPLETED_MESSAGE);
        System.out.println(task);
    }

    public void showTaskCompletedAlreadyMessage(Task task) {
        System.out.println("Task " + task.getDescription()
                + " has been completed already!");
    }

    public void showTaskDeletedMessage(Task task, TaskList tasks) {
        System.out.println(TASK_DELETED_MESSAGE);
        System.out.println(task);
        System.out.println("Now you have " + (tasks.getSize() - 1) + " tasks in your list");
    }

    public void showTaskList(TaskList tasks) {
        if (tasks.getSize() == 0) {
            System.out.println(EMPTY_TASK_LIST_MESSAGE);
        } else {
            System.out.println(TASK_LIST_MESSAGE);
            for (int taskNo = 0; taskNo < tasks.getSize(); taskNo++) {
                System.out.println((taskNo + 1) + ". " + tasks.getTask(taskNo));
            }
        }
    }

    public void showSearchList(TaskList results) {
        if (results.getSize() == 0) {
            System.out.println(INVALID_SEARCH_MESSAGE);
        } else {
            System.out.println("Here's what I have found!");
            for (int resultNo = 0; resultNo < results.getSize(); resultNo++) {
                System.out.println((resultNo + 1) + "." + results.getTask(resultNo));
            }
        }
    }

    public void showErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
