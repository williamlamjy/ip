package duke.commands;

import duke.Task;

import java.io.IOException;

/**
 * This class adds a tasks to the task list.
 */
public class AddTask extends Command {
    private Task task;

    public static final String TODO_COMMAND = "todo";
    public static final String EVENT_COMMAND = "event";
    public static final String DEADLINE_COMMAND = "deadline";

    /**
     * Initialises the AddTask class.
     * @param task Task that will be added.
     */

    public AddTask(Task task){
        this.task = task;
    }

    /**
     * Executes the adding the task to the task list.
     * It shows the AddTask messages through the ui.
     * It saves the data in the file.
     * @throws IOException Thrown when there is an error writing to the file.
     */
    @Override
    public void execute() throws IOException {
        tasks.addNewTask(task);
        ui.showTaskAddedMessage(task, tasks);
        storage.writeFile(tasks);
    }
}
