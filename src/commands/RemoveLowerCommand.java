package commands;

import java.util.Date;
import data.Worker;
import exceptions.CollectionIsEmptyException;
import exceptions.IncorrectInputInScriptException;
import exceptions.WorkerNotFoundException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.WorkerAsker;

/**
 * Command 'remove_lower'. Removes elements lower than user entered.
 */
public class RemoveLowerCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private WorkerAsker workerAsker;

    public RemoveLowerCommand(CollectionManager collectionManager, WorkerAsker workerAsker) {
        super("remove_lower {element}", "удалить из коллекции все элементы, меньшие заданного");
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
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
            Worker workerToFind = new Worker(
                    collectionManager.generateNextId(),
                    workerAsker.askName(),
                    workerAsker.askCoordinates(),
                    new Date(),
                    workerAsker.askSalary(),
                    workerAsker.askPosition(),
                    workerAsker.askStatus(),
                    workerAsker.askOrganization()
            );
            collectionManager.removeLower(workerToFind);
            Console.println("Работники успешно удалены!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}
