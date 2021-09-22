package duke;

import duke.commands.Command;
import duke.filemanager.Storage;
import duke.parser.Parser;
import duke.textui.Ui;

import java.io.IOException;

public class Duke {
    private Storage storage;
    private Ui ui;
    private TaskList tasks;
    public Duke(String filePath){
        try{
            ui = new Ui();
            storage = new Storage(filePath);
            tasks = new TaskList(storage.readFile());
        } catch (Exception e){
            ui.showFileErrorMessage();
        }
    }
    public void run() throws IOException {
        ui.showWelcomeMessage();
        boolean isExit = false;
        while(!isExit){
            try{
                String fullCommand = ui.readCommand();
                ui.showLineSeparator();
                Command command = Parser.parseInput(fullCommand);
                command.setData(tasks, ui, storage);
                command.execute();
                isExit = command.isExit();
            } catch (Exception e) {
                ui.showErrorMessage(e);
            } finally{
                ui.showLineSeparator();
            }
        }
    }
    public static void main(String[] args) throws Exception {
        new Duke("data/tasks.txt").run();
    }
}


