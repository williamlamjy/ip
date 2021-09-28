package luke.tasktype;

import luke.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This class stores the information of a deadline task
 * DeadlineDate trait stores when task is due in a YYYY-MM-DD format.
 */

public class Deadline extends Task {
    protected LocalDate deadlineDate;
    protected final static char TASK_ICON = 'D';

    /**
     * Initialises the deadline class
     *
     * @param description  Description of the deadline
     * @param deadlineDate The deadline date
     */
    public Deadline(String description, LocalDate deadlineDate) {
        super(description);
        this.deadlineDate = deadlineDate;
    }

    public String getDate() {
        return deadlineDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
    }


    /**
     * Returns a string of the formatted deadline to be written into the file
     *
     * @return String of the formatted deadline
     */
    @Override
    public String textFileFormatting() {
        return String.format(super.textFileFormatting() + ";" + deadlineDate);
    }

    /**
     * Returns the string of the formatted deadline to the command line interface
     *
     * @return String of the formatted deadline.
     */
    @Override
    public String toString() {
        return "[" + TASK_ICON + "][" + super.toString() + description + "(by: " + getDate() + ")";
    }
}

