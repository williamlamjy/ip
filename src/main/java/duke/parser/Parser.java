package duke.parser;

import duke.Task;
import duke.commands.*;

import duke.customexception.IllegalInputException;
import duke.customexception.IllegalTaskInputException;
import duke.customexception.IllegalNumberStringException;
import duke.customexception.IllegalTimeException;
import duke.tasktype.Deadline;
import duke.tasktype.Event;
import duke.tasktype.ToDo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Parser {
    public static LocalDate deadlineDate;

    public static Task identifyTaskType(String userInput) throws IllegalTaskInputException, IllegalTimeException {
        if (!(userInput.contains(" "))) {
            throw new IllegalTaskInputException();
        }
        if (userInput.startsWith("todo")) {
            String description = userInput.substring(userInput.indexOf(" ") + 1);
            return new ToDo(description);
        } else {
            if (!(userInput.contains("/")) || (userInput.indexOf("/") + 1 == userInput.length())) {
                throw new IllegalTimeException();
            }
            String timeline = userInput.substring(userInput.indexOf("/") + 1);
            String description = userInput.substring(userInput.indexOf(" ") + 1, userInput.indexOf("/"));
            if (userInput.startsWith("deadline")) {
                deadlineDate = LocalDate.parse(timeline);
                return new Deadline(description, deadlineDate);
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
    public static Command parseInput(String userInput) throws IllegalInputException, IllegalTaskInputException, IllegalNumberStringException, IllegalTimeException {
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

    public static Command prepareDeleteTask(String userInput){
        String taskNo = userInput.substring(userInput.indexOf(" ") + 1);
        int taskNoDeleted = Integer.parseInt(taskNo) - 1;
        return new DeleteTask(taskNoDeleted);
    }
    public static Command prepareAddTask(String userInput) throws IllegalTaskInputException, IllegalTimeException {
        Task addedTask = Parser.identifyTaskType(userInput);
        return new AddTask(addedTask);
    }

    public static Command prepareCheckOffTask(String userInput) throws IllegalNumberStringException {
        if((!userInput.contains(" ")) || (userInput.substring(userInput.indexOf(" ") + 1) == null)) {
            throw new IllegalNumberStringException();
        }
        String taskNo = userInput.substring(userInput.indexOf(" ") + 1);
        int taskNoCompleteIndex = Integer.parseInt(taskNo) - 1;
        return new CheckOffTask(taskNoCompleteIndex);
    }
}