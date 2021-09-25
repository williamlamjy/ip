package duke.commands;

import java.io.IOException;

/**
 * This class exits and terminates the program.
 */
public class ExitProgram extends Command{

    /**
     * Shows the goodbye messages and sets the program to exit.
     * Stores the information by writing to the file.
     * @throws IOException
     */
    @Override
    public void execute() throws IOException {
        ui.showGoodbyeMessage();
        isExit = true;
        storage.writeFile(tasks);
    }
}
