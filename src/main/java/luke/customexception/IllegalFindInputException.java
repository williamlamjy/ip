package luke.customexception;

/**
 * This class is thrown when the searchQuery is empty
 */
public class IllegalFindInputException extends Exception {
    @Override
    public String getMessage() {
        String errorMessage = "Invalid search input!\n"
                + "find: Finds a keyword and lists all relevant tasks"
                + " PARAMETERS: SEARCH_QUERY\n"
                + "Example: find meeting";
        return errorMessage;
    }
}
