package luke.customexception;

import static luke.common.Messages.FUNCTIONS_USER_GUIDE_MESSAGE;

/**
 * This class is thrown when there is no number input when it is expected to have one.
 */
public class EmptyNumberInputException extends Exception {
    @Override
    public String getMessage() {
        String errorMessage = "Please input a valid command number!\n" + FUNCTIONS_USER_GUIDE_MESSAGE;
        return errorMessage;
    }
}
