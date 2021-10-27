package commands;

import data.Status;
import exceptions.CollectionIsEmptyException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.WorkerAsker;

/**
 * Command 'remove_all_by_status'. Removes elements lower than user entered.
 */
public class RemoveByStatusCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    private WorkerAsker workerAsker;

    public RemoveByStatusCommand(CollectionManager collectionManager, WorkerAsker workerAsker) {
        super("remove_all_by_status <status>", "удалить из коллекции все элементы, равные заданному");
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
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
            Status status = Status.valueOf(argument.toUpperCase());
            collectionManager.removeByStatus(status);
            Console.println("Работники успешно удалены!");
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        }catch (IllegalArgumentException exception) {
            Console.printerror("Позиции нет в списке!");
            Console.println("Список позиций - " + Status.nameList());
        }
        return false;
    }
}
