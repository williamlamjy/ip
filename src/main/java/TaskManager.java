public class TaskManager {
    public static final int MAX_TASKS = 100;
    protected Task[] tasks;
    protected int noOfTasks;

    public TaskManager() {
        this.tasks = new Task[MAX_TASKS];
        this.noOfTasks = 0;
    }

    private Task identifyTaskType(String line) throws StringIndexOutOfBoundsException {
        if(!(line.contains(" "))){
            throw new StringIndexOutOfBoundsException();
        }
        if (line.startsWith("todo")) {
            String description = line.substring(line.indexOf(" ") + 1);
            return new ToDo(description);
        }
        else {
            if(!(line.contains("/")) || (line.indexOf("/") + 1 == line.length())){
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
            System.out.println("duke.Task " + tasks[taskNoComplete].getDescription()
                    + " has been completed already!");
        } else {
            tasks[taskNoComplete].markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(" [X] " + tasks[taskNoComplete].getDescription());
        }
    }

    public void printList() {
        if (tasks[0] == null) {
            System.out.println("Stop worrying! You have no tasks for now.");
        }
        else {
            System.out.println("Here are the tasks in your list:");
            for (int taskNo = 0; taskNo < noOfTasks; taskNo++) {
                System.out.println((taskNo + 1) + ". " + tasks[taskNo]);
            }
        }
    }
}
