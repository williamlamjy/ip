package duke.tasktype;

import duke.Task;

/**
 * This class stores the information of the todo class.
 */
public class ToDo extends Task {
    protected final static char TASK_ICON = 'T';

    public ToDo(String description) {
        super(description);
    }

    /**
     * Returns the formatted task as a string to be written into the file.
     * @return String of the formatted todo.
     */
    @Override
    public String textFormatting() {
        return String.format(super.textFormatting());
    }

    /**
     * Returns the formatted task as a string to be shown on the command line.
     * @return String of the formatted todo.
     */
    @Override
    public String toString() {
        return "[" + TASK_ICON + "][" + super.toString() + description;
    }
}
