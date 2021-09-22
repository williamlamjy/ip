package duke.common;

public class Messages {
    public static final String LINE_SEPARATOR = "---------------------" +
            "---------------------" +
            "---------------------" +
            "---------------------" +
            "---------------------" +
            "---------------------" +
            "---------------------" +
            "---------------------";
    public static final String LOGO = " _           _        \n"
            + "| |    _   _| | _____ \n"
            + "| |   | | | | |/ / _ \\\n"
            + "| |_  | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    public static final String GOODBYE_MESSAGE = "Bye! Hope to see you soon";
    public static final String TASK_ADDED_MESSAGE = "Noted! I have added this task:";
    public static final String TASK_COMPLETED_MESSAGE = "Nice! I have marked this task as done:";
    public static final String TASK_DELETED_MESSAGE = "Noted! I have deleted this task:";
    public static final String TASK_LIST_MESSAGE = "Okay! Here are your current tasks:";
    public static final String FILE_ERROR_MESSAGE = "Oh no! There seems to be an error loading this file";
    public static final String FUNCTIONS_USER_GUIDE_MESSAGE =  "done: marks a task from the list complete "
            + "Parameters: NUMBER\n"
            + "delete: deletes a task from the list "
            + "Parameters: NUMBER\n"
            + "Example: done 6";
    public static final String TASKS_USER_GUIDE_MESSAGE = "todo: Adds a new todo task "
            + "Parameters: DESCRIPTION\n"
            + "deadline: Adds a new deadline task "
            + "Parameters: DESCRIPTION /DATE\n"
            + "event: Adds a new event task"
            + "Parameters: DESCRIPTION /DURATION\n"
            + "Example: event jogging /3-4pm\n";
    public static final String WELCOME_MESSAGE =  "Hello from\n" + LOGO
            + "Im your very own personal task manager!\n"
            + "Begin by inputting your desired task\n"
            + LINE_SEPARATOR + "\n" + TASKS_USER_GUIDE_MESSAGE + LINE_SEPARATOR
            + "\nOr you can amend your current tasks in your list!\n"
            + "list: lists all your current tasks in the list\n"
            + FUNCTIONS_USER_GUIDE_MESSAGE + "\n" + LINE_SEPARATOR;
}
