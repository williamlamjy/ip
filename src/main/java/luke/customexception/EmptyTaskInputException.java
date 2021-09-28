package luke.customexception;

import static luke.common.Messages.TASKS_USER_GUIDE_MESSAGE;

/**
 * This class is thrown when the description of the task is empty.
 */
public class EmptyTaskInputException extends Exception {
    @Override
    public String getMessage() {
        String errorMessage = "Invalid task format!\n"
                + TASKS_USER_GUIDE_MESSAGE;
        return errorMessage;
    }
}
