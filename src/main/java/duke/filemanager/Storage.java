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

public class Storage {
    private File file;

    public Storage(String filePath) throws Exception{
        this.file = new File(filePath);
        if (!this.file.exists()) {
            File dir = new File("data");
            dir.mkdir();
            this.file = new File("data/duke.txt");
            file.createNewFile();
        }
    }
    public void writeFile(TaskList list) throws IOException {
        FileWriter writeToFile = new FileWriter(this.file);
        for (int i = 0; i < list.getSize(); i++) {
            writeToFile.write(list.getTaskWithFormat(i) + "\n");
        }
        writeToFile.close();
    }

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

