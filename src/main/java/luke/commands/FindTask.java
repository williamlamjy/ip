package luke.commands;

import java.io.IOException;

public class FindTask extends Command {
    private final String searchQuery;
    public static final String COMMAND_WORD = "find";

    public FindTask(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    /**
     * Executes showing the search results list.
     * Stores the information by writing to the file.
     *
     * @throws IOException Thrown when there is an error writing to file
     */
    @Override
    public void execute() throws IOException {
        ui.showSearchList(tasks.findTask(searchQuery));
        storage.writeFile(tasks);
    }
}
