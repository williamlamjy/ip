package duke.tasktype;

import duke.Task;

/**
 * This class stores the information of an event task
 * It stores the duration at which the event is held.
 */
public class Event extends Task {
    protected String duration;
    protected final static char TASK_ICON = 'E';

    /**
     * This initialises the event class
     * @param description Description of the event
     * @param duration Duration of the event
     */
    public Event(String description, String duration) {
        super(description);
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    /**
     * Returns the formatted task as a string to be written into the file.
     * @return String of the formatted event
     */
    @Override
    public String textFormatting() {
        return String.format(super.textFormatting() + ";" + getDuration());
    }

    /**
     * Returns the formatted task as a string to be displayed on the command line.
     * @return String of the formatted event
     */
    @Override
    public String toString() {
        return "[" + TASK_ICON + "][" + super.toString() + description + "(at: " + getDuration() + ")";
    }
}

