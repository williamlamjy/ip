public class ToDo extends Task {
    protected final static char TASK_ICON = 'T';

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[" + TASK_ICON + "][" + super.toString() + description;
    }
}