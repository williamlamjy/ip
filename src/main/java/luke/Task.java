package luke;

/**
 * This is the parent class to the extended task classes.
 */
public abstract class Task {
    protected boolean isDone;
    protected String description;

    /**
     * Initialises the task class
     *
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
     * Gets the X icon to be shown if the task is completed.
     *
     * @return String of status icon.
     */
    public String getStatusIcon() {
        return (isDone() ? "X" : " ");
    }

    /**
     * Checks if the task is completed.
     *
     * @return true is task is completed.
     */
    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }


    /**
     * Formats the task to be written into the file.
     * This enables more convenient reading of the file.
     *
     * @return String of the formatted task
     */
    public String textFileFormatting() {
        return String.format(this.getClass().getName() + ";" + isDone + ";" + description);
    }

    /**
     * Returns a formatted task to the user on the command line interface.
     *
     * @return String of the formatted task
     */
    public String toString() {
        return getStatusIcon() + "] ";
    }
}

