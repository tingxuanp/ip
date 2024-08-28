package bestie;

import bestie.command.Command;
import bestie.command.ExitCommand;

import java.util.Scanner;


public class Bestie {
    // load the bestie.txt file in the same directory
    //private static final String FILE_PATH = "bestie.txt";
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    Scanner sc = new Scanner(System.in);

    public Bestie(String filePath) {
        this.ui = new Ui(sc);
        this.storage = new Storage(filePath);
        this.tasks = new TaskList(storage.loadTasksFromFile());
    }

    public void run() {

        // greet the user
        this.ui.welcome();
        boolean isExit = false;

        while(!isExit) {
            String userInput = ui.readNextCommand();
            Command instruction = Parser.parse(userInput);
            instruction.execute(tasks, ui, storage);
            if (instruction instanceof ExitCommand) {
                isExit = true;
            }
        }

    }
    public static void main(String[] args){
        new Bestie("bestie.txt").run();
    }


}
