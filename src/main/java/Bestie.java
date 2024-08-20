// use Scanner class to get user inputs
import java.util.Scanner;
import java.util.ArrayList;

public class Bestie {
    public static void main(String[] args) {

        // create Scanner object to read user input
        Scanner sc = new Scanner(System.in);

        // greets the user
        System.out.println("Hello! I'm Bestie, your personal assistant chatbot.");
        System.out.println("Let's get ready to have a productive day!");
        System.out.println("What can I do for you today :)?");

        String userInput;
        ArrayList<Task> tasks = new ArrayList<>();
        // echoes commands entered by the user, and exits when the user types the command "bye"
        while (true) {
            userInput = sc.nextLine();
            if (userInput.equals("bye")) {
                break;
            }

            if (userInput.equals("list")) {
                // display the list of all items entered by the user
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < tasks.size(); i++){
                    int index = i + 1;
                    System.out.println(index +".[" + tasks.get(i).getStatusIcon() + "] " + tasks.get(i).getDescription());
                }
            } else {

                // create a new Task object for that task
                Task newTask = new Task(userInput);
                tasks.add(newTask);
                System.out.println("added: " + userInput);

            }

        }

        // exit
        System.out.println("Bye. Hope to see you again soon!");

    }
}
