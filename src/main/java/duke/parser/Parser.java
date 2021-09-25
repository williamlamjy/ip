package duke.parser;

import duke.Task;
import duke.commands.*;

import duke.customexception.IllegalInputException;
import duke.customexception.EmptyTaskInputException;
import duke.customexception.EmptyNumberInputException;
import duke.customexception.EmptyTimeException;
import duke.tasktype.Deadline;
import duke.tasktype.Event;
import duke.tasktype.ToDo;

/**
 * This class parses user inputs and returns the corresponding command or task type.
 */
public abstract class Parser {
    /**
     * Returns the corresponding command object from the user input.
     * Error messages will be shown if the input format is incorrect.
     * @param userInput The string that the user enters into the command line interface.
     * @return Command object
     * @throws Exception Throws an exception when there is an error in the user input format.
     */
    public static Command parseInput(String userInput) throws Exception {
        if(userInput.equals("bye")){
            return new ExitProgram();
        }
        if(userInput.equals("list")){
            return new PrintTasks();
        }
        if(userInput.startsWith("done")){
            return prepareCheckOffTask(userInput);
        }
        if(userInput.startsWith("delete")){
            return prepareDeleteTask(userInput);
        }
        else if(isTask(userInput)){
            return prepareAddTask(userInput);
        }
        throw new IllegalInputException();
    }


    public static Task identifyTaskType(String userInput) throws EmptyTaskInputException, EmptyTimeException {
        if (!(userInput.contains(" "))) {
            throw new EmptyTaskInputException();
        }
        if (userInput.startsWith("todo")) {
            String description = userInput.substring(userInput.indexOf(" ") + 1);
            return new ToDo(description);
        } else {
            if (!(userInput.contains("/")) || (userInput.indexOf("/") + 1 == userInput.length())) {
                throw new EmptyTimeException();
            }
            String timeline = userInput.substring(userInput.indexOf("/") + 1);
            String description = userInput.substring(userInput.indexOf(" ") + 1, userInput.indexOf("/"));
            if (userInput.startsWith("deadline")) {
                return new Deadline(description, timeline);
            } else {
                return new Event(description, timeline);
            }
        }
    }
    public static boolean isTask(String line) throws IllegalInputException {
        if (!(line.startsWith("todo") || line.startsWith("event") || line.startsWith("deadline"))) {
            throw new IllegalInputException();
        }
        return true;
    }

    public static Command prepareDeleteTask(String userInput){
        String taskNo = userInput.substring(userInput.indexOf(" ") + 1);
        int taskNoDeleted = Integer.parseInt(taskNo) - 1;
        return new DeleteTask(taskNoDeleted);
    }
    public static Command prepareAddTask(String userInput) throws EmptyTaskInputException, EmptyTimeException {
        Task addedTask = Parser.identifyTaskType(userInput);
        return new AddTask(addedTask);
    }

    public static Command prepareCheckOffTask(String userInput) throws EmptyNumberInputException {
        if((!userInput.contains(" ")) || (userInput.substring(userInput.indexOf(" ") + 1) == null)) {
            throw new EmptyNumberInputException();
        }
        String taskNo = userInput.substring(userInput.indexOf(" ") + 1);
        int taskNoCompleteIndex = Integer.parseInt(taskNo) - 1;
        return new CheckOffTask(taskNoCompleteIndex);
    }
}