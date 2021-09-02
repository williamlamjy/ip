public class Deadline extends Task {
    protected String date;
    protected final static char TASK_ICON = 'D';

    public Deadline(String description, String date) {
        super(description);
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "[" + TASK_ICON + "][" + super.toString() + description + "(by: " + getDate() + ")";
    }
}
