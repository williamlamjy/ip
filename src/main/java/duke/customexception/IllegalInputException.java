package duke.customexception;

import static duke.common.Messages.*;

public class IllegalInputException extends Exception {
    @Override
    public String getMessage(){
        String errorMessage = "Invalid command! Here are the commands available:\n"
                + TASKS_USER_GUIDE_MESSAGE
                + FUNCTIONS_USER_GUIDE_MESSAGE;
        return errorMessage;
    }
}

