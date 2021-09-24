package duke.commands;

import duke.customexception.IllegalNumberInputException;

import java.io.IOException;

public class CheckOffTask extends Command{
    private int taskNoCompletedIndex;
    public static final String COMMAND_WORD = "done";

    public CheckOffTask(int taskNoCompletedIndex) {
        this.taskNoCompletedIndex = taskNoCompletedIndex;
    }

    @Override
    public void execute() throws IOException, IllegalNumberInputException {
        if((taskNoCompletedIndex < 0) || (taskNoCompletedIndex >= tasks.getSize())){
            throw new IllegalNumberInputException();
        }
        if(tasks.getTask(taskNoCompletedIndex).isDone()){
            ui.showTaskCompletedAlreadyMessage(tasks.getTask(taskNoCompletedIndex));
        }
        else {
            tasks.checkOffTask(taskNoCompletedIndex);
            ui.showTaskCompletedMessage(tasks.getTask(taskNoCompletedIndex));
        }

        storage.writeFile(tasks);
    }
}
