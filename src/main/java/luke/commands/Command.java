package luke.commands;

import luke.TaskList;
import luke.customexception.EmptyNumberInputException;
import luke.customexception.IllegalNumberInputException;
import luke.filemanager.Storage;
import luke.textui.Ui;

import java.io.IOException;

/**
 * This is the parent class to the extended command classes.
 */
public abstract class Command {
    protected TaskList tasks;
    protected Ui ui;
    protected boolean isExit;
    protected Storage storage;

    /**
     * Initialises the command class.
     */
    public Command() {
    }

    /**
     * Sets the data by passing through the current taskList, ui and storage
     *
     * @param taskList the current list of tasks
     * @param ui       the current user interface
     * @param storage  the current file storage
     */
    public void setData(TaskList taskList, Ui ui, Storage storage) {
        this.ui = ui;
        this.tasks = taskList;
        this.storage = storage;
        this.isExit = false;
    }

    public boolean isExit() {
        return this.isExit;
    }

    public abstract void execute() throws IOException, EmptyNumberInputException, IllegalNumberInputException;
}
