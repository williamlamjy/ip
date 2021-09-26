package duke.customexception;

import static duke.common.Messages.LINE_SEPARATOR;
import static duke.common.Messages.TASKS_USER_GUIDE_MESSAGE;

/**
 * This class is thrown when the description of the task is empty.
 */
public class EmptyTaskInputException extends Exception{
    @Override
    public String getMessage(){
        String errorMessage = "Invalid task format!\n"
                + TASKS_USER_GUIDE_MESSAGE + LINE_SEPARATOR;
        return errorMessage;
    }
}
