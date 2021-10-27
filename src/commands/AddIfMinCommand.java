package commands;

import java.util.Date;

import data.Worker;
import exceptions.IncorrectInputInScriptException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.WorkerAsker;

/**
 * Command 'add_if_min'. Adds a new element to collection if it's less than the minimal one.
 */
public class AddIfMinCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private WorkerAsker workerAsker;

    public AddIfMinCommand(CollectionManager collectionManager, WorkerAsker workerAsker) {
        super("add_if_min {element}", "добавить новый элемент, если его значение меньше, чем у наименьшего");
        this.collectionManager = collectionManager;
        this.workerAsker = workerAsker;
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            Worker workerToAdd = new Worker(
                    collectionManager.generateNextId(),
                    workerAsker.askName(),
                    workerAsker.askCoordinates(),
                    new Date(),
                    workerAsker.askSalary(),
                    workerAsker.askPosition(),
                    workerAsker.askStatus(),
                    workerAsker.askOrganization()
            );
            if (collectionManager.collectionSize() == 0 || workerToAdd.compareTo(collectionManager.getFirst()) < 0) {
                collectionManager.addToCollection(workerToAdd);
                Console.println("Работник успешно добавлен!");
                return true;
            } else Console.println("Значение работника больше(либо равно), чем значение наименьшего из работников!");
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}
