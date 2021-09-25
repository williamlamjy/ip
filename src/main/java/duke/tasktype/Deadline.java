package duke.tasktype;

import duke.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected LocalDate deadlineDate;
    protected final static char TASK_ICON = 'D';

    public Deadline(String description, LocalDate deadlineDate) {
        super(description);
        this.deadlineDate = deadlineDate;
    }

    public String getDate() {
        return deadlineDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
    }

    public String textFormatting() {
        return String.format(super.textFormatting() + ";" + getDate());
    }

    @Override
    public String toString() {
        return "[" + TASK_ICON + "][" + super.toString() + description + "(by: " + getDate() + ")";
    }
}

