package duke.commands;

import java.io.IOException;

public class PrintTasks extends Command{
    public static final String COMMAND_WORD = "list";
    @Override
    public void execute() throws IOException {
        ui.showTaskList(tasks);
        storage.writeFile(tasks);
    }
}
