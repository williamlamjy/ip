public class Event extends Task{
    protected String duration;
    public Event(String description, String duration){
        super(description);
        this.duration = duration;
    }
    public String getDuration() {
        return duration;
    }
    @Override
    public String toString(){
        return super.toString() + description + "(at: " + getDuration() + ")";
    }
}
