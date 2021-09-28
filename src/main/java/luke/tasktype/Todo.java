package luke.tasktype;

import luke.Task;

/**
 * This class stores the information of the todo class.
 */
public class Todo extends Task {
    protected final static char TASK_ICON = 'T';

    public Todo(String description) {
        super(description);
    }

    /**
     * Returns the formatted task as a string to be written into the file.
     *
     * @return String of the formatted todo.
     */
    @Override
    public String textFileFormatting() {
        return String.format(super.textFileFormatting());
    }

    /**
     * Returns the formatted task as a string to be shown on the command line.
     *
     * @return String of the formatted todo.
     */
    @Override
    public String toString() {
        return "[" + TASK_ICON + "][" + super.toString() + description;
    }
}
