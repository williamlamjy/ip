package duke.tasktype;

import duke.Task;

/**
 * This class stores the information of a deadline task
 * It has an additional deadlineDate trait which stores
 * when this task is due in a YYYY-MM-DD format.
 */
public class Deadline extends Task {
    protected String date;
    protected final static char TASK_ICON = 'D';

    /**
     * Initialises the deadline class
     * @param description Description of the deadline
     * @param date The deadline date
     */
    public Deadline(String description, String date) {
        super(description);
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    /**
     * Returns a string of the formatted deadline to be written into the file
     * @return String of the formatted deadline
     */
    @Override
    public String textFormatting() {
        return String.format(super.textFormatting() + ";" + getDate());
    }

    /**
     * Returns the string of the formatted deadline to the command line interface
     * @return String of the formatted deadline.
     */
    @Override
    public String toString() {
        return "[" + TASK_ICON + "][" + super.toString() + description + "(by: " + getDate() + ")";
    }
}

