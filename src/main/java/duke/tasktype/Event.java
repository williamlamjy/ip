package duke.tasktype;

import duke.Task;

public class Event extends Task {
    protected String duration;
    protected final static char TASK_ICON = 'E';

    public Event(String description, String duration) {
        super(description);
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    public String textFormatting(){
        return String.format(super.textFormatting() + ";" + getDuration());
    }
    @Override
    public String toString() {
        return "[" + TASK_ICON + "][" + super.toString() + description + "(at: " + getDuration() + ")";
    }
}

