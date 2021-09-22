package duke;

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

    public int getSize() {
        return tasks.size();
    }

    public void addNewTask(Task addedTask){
        tasks.add(addedTask);
    }

    public void deleteTask(int taskNoDeleted) {
        tasks.remove(taskNoDeleted);
    }
    public TaskList findTask(String searchQuery){
        ArrayList<Task> emptyResults = new ArrayList<>();
        TaskList results = new TaskList(emptyResults);
        for(Task task : tasks){
            if(task.getDescription().contains(searchQuery)){
                results.addNewTask(task);
            }
        }
        return results;
    }
    public void checkOffTask(int taskNoCompletedIndex){
        tasks.get(taskNoCompletedIndex).markAsDone();
    }
}


