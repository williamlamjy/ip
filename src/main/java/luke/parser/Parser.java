package luke.parser;

import luke.Task;
import luke.commands.AddTask;
import luke.commands.CheckOffTask;
import luke.commands.Command;
import luke.commands.DeleteTask;
import luke.commands.ExitProgram;
import luke.commands.FindTask;
import luke.commands.PrintTasks;
import luke.customexception.EmptyNumberInputException;
import luke.customexception.EmptyTaskInputException;
import luke.customexception.EmptyTimeException;
import luke.customexception.IllegalFindInputException;
import luke.customexception.IllegalInputException;
import luke.tasktype.Deadline;
import luke.tasktype.Event;
import luke.tasktype.Todo;

import java.time.LocalDate;

/**
 * This class parses user inputs and returns the corresponding command or task type
 */
public abstract class Parser {
    public static LocalDate deadlineDate;

    private static String parseAfterSpace(String userInput) {
        return userInput.substring(userInput.indexOf(" ") + 1);
    }

    /**
     * Returns if userInput is separated by a space
     *
     * @param userInput The string that the user enters into the command line interface
     * @return Boolean of whether userInput is separated
     */
    private static boolean isSeparated(String userInput) {
        return userInput.contains(" ");
    }


    /**
     * Returns the corresponding command object from the user input
     * Error messages will be shown if the input format is incorrect
     *
     * @param userInput The string that the user enters into the command line interface
     * @return Command object
     * @throws Exception Thrown when there is an error in the user input format
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

    /**
     * Returns the task type when the corresponding task is added
     *
     * @param commandWord Command word that is parsed
     * @param userInput   The string that the user enters into the command line interface
     * @return Task type
     * @throws EmptyTaskInputException Thrown when the description of the task is empty
     * @throws EmptyTimeException      Thrown when the timeline of deadline/event is empty
     */
    public static Task identifyTaskType(String commandWord, String userInput)
            throws EmptyTaskInputException, EmptyTimeException {
        if (!isSeparated(userInput)) {
            throw new EmptyTaskInputException();
        }
        if (commandWord.equals(AddTask.TODO_COMMAND)) {
            String description = parseAfterSpace(userInput);
            return new Todo(description);
        } else {
            validTimelineChecker(userInput);
            String timeline = getTimeline(userInput);
            String description = getSpecialTaskDescription(userInput);
            if (userInput.startsWith("deadline")) {
                deadlineDate = LocalDate.parse(timeline);
                return new Deadline(description, deadlineDate);
            } else {
                return new Event(description, timeline);
            }
        }
    }

    /**
     * Parses the userInput to get the command word
     *
     * @param userInput The string that the user enters into the command line interface
     * @return String of the command word
     */
    private static String getCommand(String userInput) {
        String[] words = userInput.trim().split(" ", 2);
        String commandWord = words[0];
        return commandWord;
    }

    /**
     * Parses the userInput to get the task index
     *
     * @param userInput The string that the user enters into the command line interface
     * @return Task index
     */
    private static int getTaskIndex(String userInput) {
        String taskNo = parseAfterSpace(userInput);
        int taskIndex = Integer.parseInt(taskNo) - 1;
        return taskIndex;
    }

    /**
     * Parses the userInput to get the description of a event/deadline task
     *
     * @param userInput The string that the user enters into the command line interface
     * @return String of the description
     */
    private static String getSpecialTaskDescription(String userInput) {
        String description = userInput.substring(userInput.indexOf(" ") + 1, userInput.indexOf("/"));
        return description;
    }

    private static String getTimeline(String userInput) {
        String timeline = userInput.substring(userInput.indexOf("/") + 1);
        return timeline;
    }

    /**
     * Checks if the timeline of a deadline/event task is empty
     *
     * @param userInput The string that the user enters into the command line interface
     * @throws EmptyTimeException Thrown when timeline is empty
     */
    private static void validTimelineChecker(String userInput) throws EmptyTimeException {
        boolean isTimelineSeparated = userInput.contains("/");
        boolean isTimelineEmpty = (userInput.indexOf("/") + 1 == userInput.length());
        if (!isTimelineSeparated || isTimelineEmpty) {
            throw new EmptyTimeException();
        }
    }

    private static void validFindInputChecker(String userInput) throws IllegalFindInputException {
        if (!isSeparated(userInput) || (userInput.indexOf(" ") + 1 == userInput.length())) {
            throw new IllegalFindInputException();
        }
    }

    private static void validNumberInputChecker(String userInput) throws EmptyNumberInputException {
        if (!isSeparated(userInput) || (userInput.indexOf(" ") + 1 == userInput.length())) {
            throw new EmptyNumberInputException();
        }
    }

    public static Command prepareDeleteTask(String userInput) throws EmptyNumberInputException {
        validNumberInputChecker(userInput);
        int deletedTaskIndex = getTaskIndex(userInput);
        return new DeleteTask(deletedTaskIndex);
    }


    public static Command prepareAddTask(String commandWord, String userInput) throws EmptyTaskInputException, EmptyTimeException {
        Task addedTask = Parser.identifyTaskType(commandWord, userInput);
        return new AddTask(addedTask);
    }

    public static Command prepareCheckOffTask(String userInput) throws EmptyNumberInputException {
        validNumberInputChecker(userInput);
        int taskNoCompletedIndex = getTaskIndex(userInput);
        return new CheckOffTask(taskNoCompletedIndex);
    }

}

