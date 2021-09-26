package duke.commands;

import java.io.IOException;

/**
 * This class prints the current tasks ib the task list.
 */
public class PrintTasks extends Command{
    public static final String COMMAND_WORD = "list";

    /**
     * Executes printing the list of tasks through the ui.
     * Stores the information by writing to the file.
     * @throws IOException
     */
    @Override
    public void execute() throws IOException {
        ui.showTaskList(tasks);
        storage.writeFile(tasks);
    }
}
