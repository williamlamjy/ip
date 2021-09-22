package duke.commands;

import duke.TaskList;
import duke.textui.Ui;
import duke.customexception.IllegalNumberInputException;
import duke.customexception.IllegalNumberStringException;
import duke.filemanager.Storage;

import java.io.IOException;

public abstract class Command {
    protected TaskList tasks;
    protected Ui ui;
    protected boolean isExit;
    protected Storage storage;
    public Command(){
    }

    public void setData(TaskList taskList, Ui ui, Storage storage){
        this.ui = ui;
        this.tasks = taskList;
        this.storage = storage;
        this.isExit = false;
    }
    public boolean isExit(){
        return this.isExit;
    }
    public abstract void execute() throws IOException, IllegalNumberStringException, IllegalNumberInputException;
}
