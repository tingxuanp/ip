package bestie.parser;

import bestie.command.AddCommand;
import bestie.command.Command;
import bestie.command.ErrorCommand;
import bestie.task.Priority;
import bestie.task.Todo;

/**
 * Creates an instance of the Todo parser to parse a todo command.
 */
public class TodoParser {

    /**
     * Executes the todo command.
     *
     * @param userInput User command input.
     * @return Add command to add a new task if successful, Error command if an error occurs.
     */
    public Command executeCommand(String userInput) {
        try {
            String[] partsOfTodo = userInput.split(" /priority");
            String description = partsOfTodo[0].substring(5).trim();
            String priorityString = partsOfTodo[1].trim().toUpperCase();
            // distinguish the priority label
            Priority priority = Priority.valueOf(priorityString);
            return new AddCommand(new Todo(description, priority));
        } catch (StringIndexOutOfBoundsException e) {
            return new ErrorCommand("The description of a todo cannot be empty.\n"
                    + "Please input your todo again!");
        } catch (IllegalArgumentException e) {
            return new ErrorCommand("Invalid priority :(."
                    + " Please specify as 'high', 'medium' or 'low'.");
        } catch (ArrayIndexOutOfBoundsException e) {
            return new ErrorCommand("You did not key in the priority of your task! "
                    + "Remember to indicate the priority with the command \"/priority\"");
        }
    }
}
