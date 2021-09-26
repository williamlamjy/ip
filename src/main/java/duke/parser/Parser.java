package duke.parser;

import duke.Task;
import duke.commands.*;


import duke.customexception.*;

import duke.tasktype.Deadline;
import duke.tasktype.Event;
import duke.tasktype.ToDo;
import java.time.LocalDate;

/**
 * This class parses user inputs and returns the corresponding command or task type.
 */
public abstract class Parser {
    public static LocalDate deadlineDate;

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


    /**
     * Returns the corresponding command object from the user input.
     * Error messages will be shown if the input format is incorrect.
     * @param userInput The string that the user enters into the command line interface.
     * @return Command object
     * @throws Exception Throws an exception when there is an error in the user input format.
     */
    public static Command parseInput(String userInput) throws Exception {
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

    public static Task identifyTaskType(String commandWord, String userInput) throws EmptyTaskInputException, EmptyTimeException {
        if (!(userInput.contains(" "))) {
            throw new EmptyTaskInputException();
        }
        if(commandWord.equals(AddTask.TODO_COMMAND)){
            String description = parseAfterSpace(userInput);
            return new ToDo(description);
        } else {
            validTimelineChecker(userInput);
            String timeline = getTimeline(userInput);
            String description = getDescription(userInput);
            if (userInput.startsWith("deadline")) {
                deadlineDate = LocalDate.parse(timeline);
                return new Deadline(description, deadlineDate);
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

    private static void validTimelineChecker(String userInput) throws EmptyTimeException {
        boolean isTimelineSeparated = userInput.contains("/");
        boolean isTimelineEmpty = (userInput.indexOf("/") + 1 == userInput.length());
        if (!isTimelineSeparated || isTimelineEmpty) {
            throw new EmptyTimeException();
        }
    }

    private static void validFindInputChecker(String userInput) throws IllegalFindInputException {
        if (!isSeparated(userInput)) {
            throw new IllegalFindInputException();
        }
    }

    public static Command prepareDeleteTask(String userInput) throws EmptyNumberInputException{
        if(!isSeparated(userInput) || (parseAfterSpace(userInput).equals(null))) {
            throw new EmptyNumberInputException();
        }
        int taskNoDeleted = getTaskIndex(userInput);
        return new DeleteTask(taskNoDeleted);
    }


    public static Command prepareAddTask(String commandWord, String userInput) throws EmptyTaskInputException, EmptyTimeException {
        Task addedTask = Parser.identifyTaskType(commandWord, userInput);
        return new AddTask(addedTask);
    }

    public static Command prepareCheckOffTask(String userInput) throws EmptyNumberInputException {
        if(!isSeparated(userInput) || (parseAfterSpace(userInput).equals(null))) {
            throw new EmptyNumberInputException();
        }
        int taskNoCompletedIndex = getTaskIndex(userInput);
        return new CheckOffTask(taskNoCompletedIndex);
    }
}
