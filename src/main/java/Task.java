public class Task {
    protected boolean isDone;
    protected String description;
    protected static int noOfTasks = 0;
    protected String taskIcon;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.taskIcon = taskIcon;
        noOfTasks++;
    }

    public String getDescription() {
        return description;
    }

    public static int getNoOfTasks() {
        return noOfTasks;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    public String getStatusIcon() {
        return (isDone() ? "X" : " ");
    }

    public String toString() {
        return "[" + taskIcon + "][" + getStatusIcon() + "] ";
    }
}
