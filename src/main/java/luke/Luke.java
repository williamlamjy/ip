package luke;

import luke.commands.Command;
import luke.filemanager.Storage;
import luke.parser.Parser;
import luke.textui.Ui;

/**
 * This program acts as a task manager list. It is able to read in tasks and add them to the list.
 * It is able to mark tasks complete, find tasks, delete tasks and print current tasks out.
 *
 * @author Lam Junyu William
 * @version v0.1
 * @since 26-9-2021
 */
public class Luke {
    private Storage storage;
    private Ui ui;
    private TaskList tasks;

    /**
     * This is the startup of the program. The file storage, user interface and TaskList is initialized here.
     * Any error with the file loading will lead to termination of the program.
     * random edit hi
     * @param filePath path of the file where data of the pre-existing task list is stored at.
     */
    public Luke(String filePath) {
        try {
            ui = new Ui();
            storage = new Storage(filePath);
            tasks = new TaskList(storage.readFile());
        } catch (Exception e) {
            ui.showFileErrorMessage();
            System.exit(-1);
        }
    }

    /**
     * Runs the program and reads in input from the user and executes the corresponding command.
     * Any error in the input will be reflected through error messages.
     */
    public void run() {
        ui.showWelcomeMessage();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLineSeparator();
                Command command = Parser.parseInput(fullCommand);
                command.setData(tasks, ui, storage);
                command.execute();
                isExit = command.isExit();
            } catch (Exception e) {
                ui.showErrorMessage(e);
            } finally {
                ui.showLineSeparator();
            }
        }
    }

    /**
     * Main method creates the instance of the program and runs it.
     */
    public static void main(String[] args) {
        new Luke("data/luke.txt").run();
    }
}


