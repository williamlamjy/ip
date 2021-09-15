package duke.tasktype;

import duke.Task;

public class ToDo extends Task {
    protected final static char TASK_ICON = 'T';

    public ToDo(String description) {
        super(description);
    }

    public String textFormatting(){
        return String.format(super.textFormatting());
    }
    @Override
    public String toString() {
        return "[" + TASK_ICON + "][" + super.toString() + description;
    }
}
