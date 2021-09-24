package duke.commands;

import duke.customexception.IllegalNumberInputException;

import java.io.IOException;

public class DeleteTask extends Command{
    private int taskNoDeleted;
    public static final String COMMAND_WORD = "delete";
    public DeleteTask(int taskNoDeleted) {
        this.taskNoDeleted = taskNoDeleted;
    }

    @Override
    public void execute() throws IOException, IllegalNumberInputException {
        if(taskNoDeleted < 0 || taskNoDeleted >= tasks.getSize()){
            throw new IllegalNumberInputException();
        }
        ui.showTaskDeletedMessage(tasks.getTask(taskNoDeleted), tasks);
        tasks.deleteTask(taskNoDeleted);
        storage.writeFile(tasks);
    }
}
