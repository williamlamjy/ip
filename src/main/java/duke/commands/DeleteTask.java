package duke.commands;

import java.io.IOException;

/**
 * This class deletes a task from the task list.
 */
public class DeleteTask extends Command{
    private int deletedTaskIndex;

    /**
     * Initialises the DeleteTask class.
     * @param deletedTaskIndex Index of the task that will be deleted.
     */
    public DeleteTask(int deletedTaskIndex) {
        this.deletedTaskIndex = deletedTaskIndex;
    }

    /**
     * Executes deleting the task from the task list.
     * Shows delete task messages.
     * Stores the information by writing into the file.
     * @throws IOException
     */
    @Override
    public void execute() throws IOException {
        ui.showTaskDeletedMessage(tasks.getTask(deletedTaskIndex), tasks);
        tasks.deleteTask(deletedTaskIndex);
        storage.writeFile(tasks);
    }
}
