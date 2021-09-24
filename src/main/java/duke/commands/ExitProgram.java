package duke.commands;

import java.io.IOException;

public class ExitProgram extends Command{
    public static final String COMMAND_WORD = "bye";
    @Override
    public void execute() throws IOException {
        ui.showGoodbyeMessage();
        isExit = true;
        storage.writeFile(tasks);
    }
}
