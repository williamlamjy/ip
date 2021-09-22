package duke.commands;

import java.io.IOException;

public class PrintTasks extends Command{

    @Override
    public void execute() throws IOException {
        ui.showTaskList(tasks);
        storage.writeFile(tasks);
    }
}
