package duke.customexception;

import static duke.common.Messages.FUNCTIONS_USER_GUIDE_MESSAGE;

public class IllegalNumberStringException extends Exception{
    @Override
    public String getMessage(){
        String errorMessage = "Please input a valid command number!\n" + FUNCTIONS_USER_GUIDE_MESSAGE;
        return errorMessage;
    }
}
