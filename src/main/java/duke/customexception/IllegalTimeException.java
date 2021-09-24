package duke.customexception;

import static duke.common.Messages.TASKS_USER_GUIDE_MESSAGE;

public class IllegalTimeException extends Exception {
    @Override
    public String getMessage(){
        String errorMessage = "Invalid event duration or deadline date input\n"
                + TASKS_USER_GUIDE_MESSAGE;
        return errorMessage;
    }
}
