public class TaskList {
    protected Task[] tasks;
    protected int noOfTasks;

    public TaskList() {
        this.tasks = new Task[100];
        this.noOfTasks = 0;
    }

    private Task identifyTaskType(String line) {
        if (line.startsWith("todo")) {
            String description = line.substring(line.indexOf(" ") + 1);
            return new ToDo(description);
        } else {
            String timeline = line.substring(line.indexOf("/") + 1);
            String description = line.substring(line.indexOf(" ") + 1, line.indexOf("/"));
            if (line.startsWith("deadline")) {
                return new Deadline(description, timeline);
            } else {
                return new Event(description, timeline);
            }
        }
    }

    public void addTask(String line) {
        Task addedTask = identifyTaskType(line);
        tasks[noOfTasks] = addedTask;
        System.out.println("Noted! I have added this task:");
        System.out.println(tasks[noOfTasks]);
        System.out.println("Now you have " + (noOfTasks + 1) + " tasks in your list.");
        noOfTasks++;
    }

    public void checkOffTask(String line) {
        String taskNo = line.substring(line.indexOf(" ") + 1);
        int taskNoComplete = Integer.parseInt(taskNo) - 1;
        if (tasks[taskNoComplete].isDone()) {
            System.out.println("Task " + tasks[taskNoComplete].getDescription() + " has been completed already!");
        } else {
            tasks[taskNoComplete].markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(" [X] " + tasks[taskNoComplete].getDescription());
        }
    }

    public void printTaskList() {
        if (tasks[0] != null) {
            System.out.println("Here are the tasks in your list:");
            for (int taskNo = 0; taskNo < noOfTasks; taskNo++) {
                System.out.println((taskNo + 1) + ". " + tasks[taskNo]);
            }
        } else {
            System.out.println("Stop worrying! You have no tasks for now.");
        }
    }
}
