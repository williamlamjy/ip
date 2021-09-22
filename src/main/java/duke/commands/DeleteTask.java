package duke.commands;

import java.io.IOException;

public class DeleteTask extends Command{
    private int taskNoDeleted;

    public DeleteTask(int taskNoDeleted) {
        this.taskNoDeleted = taskNoDeleted;
    }

    @Override
    public void execute() throws IOException {
        ui.showTaskDeletedMessage(tasks.getTask(taskNoDeleted), tasks);
        tasks.deleteTask(taskNoDeleted);
        storage.writeFile(tasks);
    }
}
