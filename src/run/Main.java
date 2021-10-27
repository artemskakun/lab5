package run;

import commands.*;
import utility.*;

import java.util.Scanner;

/**
 * Main application class. Creates all instances and runs the program.
 * @author Skakun Artem
 */
public class Main {
    public static void main(String... args) {
        try (Scanner userScanner = new Scanner(System.in)) {
            final String envVariable = "LABA";

            WorkerAsker workerAsker = new WorkerAsker(userScanner);
            FileManager fileManager = new FileManager(envVariable);
            CollectionManager collectionManager = new CollectionManager(fileManager);
            CommandManager commandManager = new CommandManager(
                    new HelpCommand(),
                    new InfoCommand(collectionManager),
                    new ShowCommand(collectionManager),
                    new AddCommand(collectionManager, workerAsker),
                    new UpdateCommand(collectionManager, workerAsker),
                    new RemoveByIdCommand(collectionManager),
                    new ClearCommand(collectionManager),
                    new SaveCommand(collectionManager),
                    new ExitCommand(),
                    new ExecuteScriptCommand(),
                    new AddIfMinCommand(collectionManager, workerAsker),
                    new AddIfMaxCommand(collectionManager, workerAsker),
                    new RemoveLowerCommand(collectionManager, workerAsker),
                    new RemoveByStatusCommand(collectionManager, workerAsker),
                    new CountByPositionCommand(collectionManager, workerAsker),
                    new PrintAscendingCommand(collectionManager)
            );
            Console console = new Console(commandManager, userScanner, workerAsker);

            console.interactiveMode();
        }
    }
}