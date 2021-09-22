package duke.parser;

import duke.Task;
import duke.commands.*;

import duke.customexception.*;
import duke.tasktype.Deadline;
import duke.tasktype.Event;
import duke.tasktype.ToDo;

public abstract class Parser {
    public static Task identifyTaskType(String userInput) throws IllegalTaskInputException, IllegalTimeException {
        if (!(userInput.contains(" "))) {
            throw new IllegalTaskInputException();
        }
        if (userInput.startsWith("todo")) {
            String description = getSubstring(userInput, " ");
            return new ToDo(description);
        } else {
            if (!(userInput.contains("/")) || (userInput.indexOf("/") + 1 == userInput.length())) {
                throw new IllegalTimeException();
            }
            String timeline = getSubstring(userInput, "/");
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
    public static Command parseInput(String userInput) throws IllegalInputException, IllegalTaskInputException,
            IllegalNumberStringException, IllegalTimeException, IllegalFindInputException {
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
        if(userInput.startsWith("find")) {
            if(!(userInput.contains(" "))){
                throw new IllegalFindInputException();
            }
            if(getSubstring(userInput," ").equals(" ")){
                throw new IllegalFindInputException();
            }
            String searchQuery = getSubstring(userInput, " ");
            return new FindTask(searchQuery);
        }
        else if(isTask(userInput)){
            return prepareAddTask(userInput);
        }
        throw new IllegalInputException();
    }

    private static String getSubstring(String userInput, String character) {
        return userInput.substring(userInput.indexOf(character) + 1);
    }

    public static Command prepareDeleteTask(String userInput){
        String taskNo = getSubstring(userInput, " ");
        int taskNoDeleted = Integer.parseInt(taskNo) - 1;
        return new DeleteTask(taskNoDeleted);
    }
    public static Command prepareAddTask(String userInput) throws IllegalTaskInputException, IllegalTimeException {
        Task addedTask = Parser.identifyTaskType(userInput);
        return new AddTask(addedTask);
    }

    public static Command prepareCheckOffTask(String userInput) throws IllegalNumberStringException {
        if((!userInput.contains(" ")) || (getSubstring(userInput, " ") == null)) {
            throw new IllegalNumberStringException();
        }
        String taskNo = getSubstring(userInput, " ");
        int taskNoCompleteIndex = Integer.parseInt(taskNo) - 1;
        return new CheckOffTask(taskNoCompleteIndex);
    }
}