package duke.commands;

import java.io.IOException;

public class FindTask extends Command{
    private String searchQuery;
    public static final String COMMAND_WORD = "find";
    public FindTask(String searchQuery){
        this.searchQuery = searchQuery;
    }
    @Override
    public void execute() throws IOException {
        ui.showSearchList(tasks.findTask(searchQuery));
        storage.writeFile(tasks);
    }
}
