package luke;

import java.util.ArrayList;

/**
 * This class contains the arraylist for all the current tasks.
 * It is then able to handle functions to the tasks like add,delete and checkOff.
 */
public class TaskList {
    protected ArrayList<Task> tasks;

    /**
     * Initialises the task list.
     *
     * @param tasks the list of tasks
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public Task getTask(int taskIndex) {
        return tasks.get(taskIndex);
    }

    /**
     * Gets a task and returns a string with a format to write into the luke file.
     * This format enables easier reading and processing of the tasks in the file.
     *
     * @param taskIndex Index of the task to format
     * @return String of the formatted task
     */
    public String getTaskWithFileFormat(int taskIndex) {
        return tasks.get(taskIndex).textFileFormatting();
    }

    public int getSize() {
        return tasks.size();
    }

    public void addTask(Task addedTask) {
        tasks.add(addedTask);
    }

    public void deleteTask(int deletedTaskIndex) {
        tasks.remove(deletedTaskIndex);
    }

    /**
     * Returns a new taskList of the tasks that contains the searchQuery.
     *
     * @param searchQuery Word or phrase input to search for
     * @return TaskList of tasks containing the searchQuery
     */
    public TaskList findTask(String searchQuery) {
        ArrayList<Task> emptyResults = new ArrayList<>();
        TaskList results = new TaskList(emptyResults);
        for (Task task : tasks) {
            if (task.getDescription().contains(searchQuery)) {
                results.addTask(task);
            }
        }
        return results;
    }

    public void checkOffTask(int taskNoCompletedIndex) {
        tasks.get(taskNoCompletedIndex).markAsDone();
    }
}


