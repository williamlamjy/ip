package duke.commands;

import java.io.IOException;

public class ExitProgram extends Command{
    @Override
    public void execute() throws IOException {
        ui.showGoodbyeMessage();
        isExit = true;
        storage.writeFile(tasks);
    }
}
