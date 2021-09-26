package duke.customexception;

/**
 * This class is thrown when the user inputs a number that is not within the size of the task list.
 */
public class IllegalNumberInputException extends Exception{
    @Override
    public String getMessage(){
        String errorMessage = "Number input is not in the list.\n" +
             "Please input a number that is within the range of the list";
        return errorMessage;
    }
}
