package luke.commands;

import luke.customexception.IllegalNumberInputException;

import java.io.IOException;

/**
 * This class checks off a task in the task list as done.
 */
public class CheckOffTask extends Command {
    private final int taskNoCompletedIndex;
    public static final String COMMAND_WORD = "done";

    /**
     * Initialises the CheckOffTask class.
     *
     * @param taskNoCompletedIndex Index of the task that is completed.
     */
    public CheckOffTask(int taskNoCompletedIndex) {
        this.taskNoCompletedIndex = taskNoCompletedIndex;
    }

    /**
     * Executes checking off the task in the task list.
     * Shows the message after checking off the task.
     * Stores the data by writing into the file
     *
     * @throws IOException                 Thrown when there is an error writing into the file
     * @throws IllegalNumberInputException Thrown when the index provided is not within the size of the task list.
     */
    @Override
    public void execute() throws IOException, IllegalNumberInputException {
        if ((taskNoCompletedIndex < 0) || (taskNoCompletedIndex >= tasks.getSize())) {
            throw new IllegalNumberInputException();
        }
        if (tasks.getTask(taskNoCompletedIndex).isDone()) {
            ui.showTaskCompletedAlreadyMessage(tasks.getTask(taskNoCompletedIndex));
        } else {
            tasks.checkOffTask(taskNoCompletedIndex);
            ui.showTaskCompletedMessage(tasks.getTask(taskNoCompletedIndex));
        }

        storage.writeFile(tasks);
    }
}
