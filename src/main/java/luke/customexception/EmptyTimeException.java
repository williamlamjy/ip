package luke.customexception;

import static luke.common.Messages.TASKS_USER_GUIDE_MESSAGE;

/**
 * This class is thrown when the deadline date or event duration is empty.
 */
public class EmptyTimeException extends Exception {
    @Override
    public String getMessage() {
        String errorMessage = "Invalid event duration or deadline date input\n"
                + TASKS_USER_GUIDE_MESSAGE;
        return errorMessage;
    }
}
