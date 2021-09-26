package duke;

import duke.customexception.IllegalNumberInputException;

import java.util.ArrayList;

/**
 * This class contains the arraylist for all the current tasks.
 * It is then able to handle functions to the tasks like add,delete and checkOff.
 */
public class TaskList {
    protected ArrayList<Task> tasks;

    /**
     * Initialises the task list.
     * @param tasks the list of tasks
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }


    public Task getTask(int taskNo) {
        return tasks.get(taskNo);
    }

    /**
     * Gets a task and returns a string with a format to write into the luke file.
     * This format enables easier reading and processing of the tasks in the file.
     * @param taskIndex Index of the task to format
     * @return String of the formatted task
     */
    public String getTaskWithFormat(int taskIndex){
        return tasks.get(taskIndex).textFormatting();
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


