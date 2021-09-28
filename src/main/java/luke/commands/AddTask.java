package luke.commands;

import luke.Task;

import java.io.IOException;

/**
 * This class adds a tasks to the task list.
 */
public class AddTask extends Command {
    private final Task task;

    public static final String TODO_COMMAND = "todo";
    public static final String EVENT_COMMAND = "event";
    public static final String DEADLINE_COMMAND = "deadline";

    /**
     * Initialises the AddTask class.
     *
     * @param task Task that will be added.
     */

    public AddTask(Task task) {
        this.task = task;
    }

    /**
     * Executes adding the task to the task list.
     * Shows the AddTask messages through the ui.
     * Saves the data in the file.
     *
     * @throws IOException Thrown when there is an error writing to the file.
     */
    @Override
    public void execute() throws IOException {
        tasks.addTask(task);
        ui.showTaskAddedMessage(task, tasks);
        storage.writeFile(tasks);
    }
}
