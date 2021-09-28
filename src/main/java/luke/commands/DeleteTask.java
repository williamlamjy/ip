package luke.commands;

import luke.customexception.IllegalNumberInputException;

import java.io.IOException;

/**
 * This class deletes a task from the task list.
 */
public class DeleteTask extends Command {

    private final int deletedTaskIndex;
    public static final String COMMAND_WORD = "delete";

    /**
     * Initialises the DeleteTask class.
     *
     * @param deletedTaskIndex Index of the task that will be deleted.
     */
    public DeleteTask(int deletedTaskIndex) {
        this.deletedTaskIndex = deletedTaskIndex;
    }

    /**
     * Executes deleting the task from the task list.
     * Shows delete task messages.
     * Stores the information by writing into the file.
     *
     * @throws IOException Thrown when there is an error writing to file
     */
    @Override
    public void execute() throws IOException, IllegalNumberInputException {
        if (deletedTaskIndex < 0 || deletedTaskIndex >= tasks.getSize()) {
            throw new IllegalNumberInputException();
        }
        ui.showTaskDeletedMessage(tasks.getTask(deletedTaskIndex), tasks);
        tasks.deleteTask(deletedTaskIndex);
        storage.writeFile(tasks);
    }
}
