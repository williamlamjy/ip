package duke;

import duke.customexception.IllegalNumberInputException;

import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }


    public Task getTask(int taskNo) {
        return tasks.get(taskNo);
    }

    public String getTaskWithFormat(int taskNo){
        return tasks.get(taskNo).textFormatting();
    }
    public void markDone(int taskNo) {
        tasks.get(taskNo).isDone = true;
    }

    public int getSize() {
        return tasks.size();
    }

    public void addNewTask(Task addedTask){
        tasks.add(addedTask);
    }

    public void deleteTask(int taskNoDeleted) throws IndexOutOfBoundsException {
        tasks.remove(taskNoDeleted);
    }

    public void checkOffTask(int taskNoCompletedIndex) throws IllegalNumberInputException {

        tasks.get(taskNoCompletedIndex).markAsDone();
    }
}


