package duke;

/**
 * This is the parent class to the extended task classes.
 */
public abstract class Task {
    protected boolean isDone;
    protected String description;

    /**
     * Initialises the task class
     * @param description Description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Checks if the task is completed.
     * @return true is task is completed.
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Formats the task to be written into the file.
     * This enables more convenient reading of the file.
     * @return String of the formatted task
     */
    public String textFormatting() {
        return String.format(this.getClass().getName() + ";" + isDone + ";" + description);
    }

    public void markAsDone() {
        isDone = true;
    }

    /**
     * Gets the X icon to be shown if the task is completed.
     * @return String of status icon.
     */
    public String getStatusIcon() {
        return (isDone() ? "X" : " ");
    }

    /**
     * Returns a formatted task to the user on the command line interface.
     * @return String of the formatted task
     */
    public String toString() {
        return getStatusIcon() + "] ";
    }
}

