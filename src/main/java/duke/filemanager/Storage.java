package duke.filemanager;

import duke.Task;
import duke.TaskList;
import duke.tasktype.Deadline;
import duke.tasktype.Event;
import duke.tasktype.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

import static duke.parser.Parser.deadlineDate;

/**
 * This class stores data of the task list by reading, writing and loading the luke file.
 */
public class Storage {
    private File file;

    /**
     * Initializes the Storage class with a file object.
     * If the file does not exist, a new file and directory will be created.
     * @param filePath name and directory of the file to be loaded/saved.
     * @throws Exception Throws exception when there is an error loading/reading the file.
     */
    public Storage(String filePath) throws Exception{
        this.file = new File(filePath);
        if (!this.file.exists()) {
            File dir = new File("data");
            dir.mkdir();
            this.file = new File("data/luke.txt");
            file.createNewFile();
        }
    }

    /**
     * Writes the current tasks to the file and stores the data.
     * @param tasks The current task list that is written to the file
     * @throws IOException Exception thrown when there is an error writing to the file.
     */
    public void writeFile(TaskList tasks) throws IOException {
        FileWriter writeToFile = new FileWriter(this.file);
        for (int i = 0; i < tasks.getSize(); i++) {
            writeToFile.write(tasks.getTaskWithFormat(i) + "\n");
        }
        writeToFile.close();
    }

    /**
     * Creates an arraylist to store all the current tasks in the file.
     * This arraylist will be passed to store the current commands.
     * This enables the user to load up the pre-existing task list and add more tasks to it.
     * @return
     * @throws FileNotFoundException
     */
    public ArrayList<Task> readFile() throws FileNotFoundException {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner s = new Scanner(file);
        int taskNo = 0;
        while (s.hasNext()) {
            String[] textSegment = s.nextLine().split(";");
            if (textSegment[0].equals("duke.tasktype.ToDo")) {
                Task todo = new ToDo(textSegment[2]);
                tasks.add(todo);
                if (textSegment[1].equals("true")) {
                    tasks.get(taskNo).markAsDone();
                }
            } else if (textSegment[0].equals("duke.tasktype.Event")) {
                Task event = new Event(textSegment[2], textSegment[3]);
                tasks.add(event);
                if (textSegment[1].equals("true")) {
                    tasks.get(taskNo).markAsDone();
                }
            } else {
                deadlineDate = LocalDate.parse(textSegment[3]);
                Task deadline = new Deadline(textSegment[2], deadlineDate);
                tasks.add(deadline);
                if (textSegment[1].equals("true")) {
                    tasks.get(taskNo).markAsDone();
                }
            }
            taskNo++;
        }
        return tasks;
    }

}
