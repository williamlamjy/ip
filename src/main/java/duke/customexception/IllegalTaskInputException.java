package duke.customexception;

import static duke.common.Messages.TASKS_USER_GUIDE_MESSAGE;

public class IllegalTaskInputException extends Exception{
    @Override
    public String getMessage(){
        String errorMessage = "Invalid task format!\n"
                + TASKS_USER_GUIDE_MESSAGE;
        return errorMessage;
    }
}
