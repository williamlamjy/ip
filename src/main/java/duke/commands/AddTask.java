package duke.commands;

import duke.Task;

import java.io.IOException;

public class AddTask extends Command {
    private Task task;

    public AddTask(Task task){
        this.task = task;
    }

    @Override
    public void execute() throws IOException {
        tasks.addNewTask(task);
        ui.showTaskAddedMessage(task, tasks);
        storage.writeFile(tasks);
    }
}
