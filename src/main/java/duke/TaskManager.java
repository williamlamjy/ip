package duke;

import duke.tasktype.Deadline;
import duke.tasktype.Event;
import duke.tasktype.ToDo;

import java.util.ArrayList;

public class TaskManager {
    protected ArrayList<Task> tasks;
    protected int noOfTasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.noOfTasks = 0;
    }

    private Task identifyTaskType(String line) throws StringIndexOutOfBoundsException {
        if (!(line.contains(" "))) {
            throw new StringIndexOutOfBoundsException();
        }
        if (line.startsWith("todo")) {
            String description = line.substring(line.indexOf(" ") + 1);
            return new ToDo(description);
        } else {
            if (!(line.contains("/")) || (line.indexOf("/") + 1 == line.length())) {
                throw new StringIndexOutOfBoundsException();
            }
            String timeline = line.substring(line.indexOf("/") + 1);
            String description = line.substring(line.indexOf(" ") + 1, line.indexOf("/"));
            if (line.startsWith("deadline")) {
                return new Deadline(description, timeline);
            } else {
                return new Event(description, timeline);
            }
        }
    }

    public void addTask(String line) throws StringIndexOutOfBoundsException {
        Task addedTask = identifyTaskType(line);
        tasks.add(addedTask);
        System.out.println("Noted! I have added this task:");
        System.out.println(tasks.get(noOfTasks));
        System.out.println("Now you have " + (noOfTasks + 1) + " tasks in your list.");
        noOfTasks++;
    }

    public void deleteTask(String line) throws IndexOutOfBoundsException {
        String taskNo = line.substring(line.indexOf(" ") + 1);
        int taskNoDeleted = Integer.parseInt(taskNo) - 1;
        Task deletedTask = tasks.get(taskNoDeleted);
        tasks.remove(taskNoDeleted);
        System.out.println("Noted. I have deleted this task:");
        System.out.println(deletedTask);
        System.out.println("Now you have " + (noOfTasks - 1) + " tasks in your list");
        noOfTasks--;
    }

    public void checkOffTask(String line) {
        String taskNo = line.substring(line.indexOf(" ") + 1);
        int taskNoComplete = Integer.parseInt(taskNo) - 1;
        if (tasks.get(taskNoComplete).isDone()) {
            System.out.println("Task " + tasks.get(taskNoComplete).getDescription()
                    + " has been completed already!");
        } else {
            tasks.get(taskNoComplete).markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(" [X] " + tasks.get(taskNoComplete).getDescription());
        }
    }

    public String getTask(int taskNo) {
        return tasks.get(taskNo).textFormatting();
    }

    public void markDone(int taskNo) {
        tasks.get(taskNo).isDone = true;
    }

    public int getSize() {
        return tasks.size();
    }

    public void printList() {
        if (tasks.size() == 0) {
            System.out.println("Stop worrying! You have no tasks for now.");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int taskNo = 0; taskNo < noOfTasks; taskNo++) {
                System.out.println((taskNo + 1) + ". " + tasks.get(taskNo));
            }
        }
    }
}


