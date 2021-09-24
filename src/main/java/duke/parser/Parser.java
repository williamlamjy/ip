package duke.parser;

import duke.Task;
import duke.commands.*;

import duke.customexception.*;
import duke.tasktype.Deadline;
import duke.tasktype.Event;
import duke.tasktype.ToDo;

public abstract class Parser {

    private static String parseAfterSpace(String userInput) {
        return userInput.substring(userInput.indexOf(" ") + 1);
    }

    private static int getTaskIndex(String userInput) {
        String taskNo = parseAfterSpace(userInput);
        int taskIndex = Integer.parseInt(taskNo) - 1;
        return taskIndex;
    }

    private static boolean isSeparated(String userInput){
        return userInput.contains(" ");
    }

    private static String getCommand(String userInput){
        String[] words = userInput.trim().split(" ", 2);
        String commandWord = words[0];
        return commandWord;
    }

    public static Task identifyTaskType(String commandWord, String userInput) throws IllegalTaskInputException, IllegalTimeException {
        if (!isSeparated(userInput)) {
            throw new IllegalTaskInputException();
        }
        if(commandWord.equals(AddTask.TODO_COMMAND)){
            String description = parseAfterSpace(userInput);
            return new ToDo(description);
        } else {
            validTimelineChecker(userInput);
            String timeline = getTimeline(userInput);
            String description = getDescription(userInput);
            if (userInput.startsWith("deadline")) {
                return new Deadline(description, timeline);
            } else {
                return new Event(description, timeline);
            }
        }
    }

    private static String getDescription(String userInput) {
        String description = userInput.substring(userInput.indexOf(" ") + 1, userInput.indexOf("/"));
        return description;
    }

    private static String getTimeline(String userInput) {
        String timeline = userInput.substring(userInput.indexOf("/") + 1);
        return timeline;
    }

    private static void validTimelineChecker(String userInput) throws IllegalTimeException {
        boolean isTimelineSeparated = userInput.contains("/");
        boolean isTimelineEmpty = (userInput.indexOf("/") + 1 == userInput.length());
        if (!isTimelineSeparated || isTimelineEmpty) {
            throw new IllegalTimeException();
        }
    }

    private static void validFindInputChecker(String userInput) throws IllegalFindInputException {
        if (!isSeparated(userInput)) {
            throw new IllegalFindInputException();
        }
    }

    public static Command parseInput(String userInput) throws IllegalInputException, IllegalTaskInputException,
            IllegalNumberStringException, IllegalTimeException, IllegalFindInputException {
        String commandWord = getCommand(userInput);
        switch (commandWord) {
        case ExitProgram.COMMAND_WORD:
            return new ExitProgram();
        case PrintTasks.COMMAND_WORD:
            return new PrintTasks();
        case CheckOffTask.COMMAND_WORD:
            return prepareCheckOffTask(userInput);
        case DeleteTask.COMMAND_WORD:
            return prepareDeleteTask(userInput);
        case FindTask.COMMAND_WORD:
            validFindInputChecker(userInput);
            String searchQuery = parseAfterSpace(userInput);
            return new FindTask(searchQuery);
        case AddTask.TODO_COMMAND:
        case AddTask.EVENT_COMMAND:
        case AddTask.DEADLINE_COMMAND:
            return prepareAddTask(commandWord, userInput);
        default:
            throw new IllegalInputException();
        }
    }

    public static Command prepareDeleteTask(String userInput) throws IllegalNumberStringException{
        if(!isSeparated(userInput) || (parseAfterSpace(userInput).equals(null))) {
            throw new IllegalNumberStringException();
        }
        int taskNoDeleted = getTaskIndex(userInput);
        return new DeleteTask(taskNoDeleted);
    }

    public static Command prepareAddTask(String commandWord, String userInput) throws IllegalTaskInputException, IllegalTimeException {
        Task addedTask = Parser.identifyTaskType(commandWord, userInput);
        return new AddTask(addedTask);
    }

    public static Command prepareCheckOffTask(String userInput) throws IllegalNumberStringException {
        if(!isSeparated(userInput) || (parseAfterSpace(userInput).equals(null))) {
            throw new IllegalNumberStringException();
        }
        int taskNoCompletedIndex = getTaskIndex(userInput);
        return new CheckOffTask(taskNoCompletedIndex);
    }
}
