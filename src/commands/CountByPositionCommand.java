package commands;

import data.Position;
import exceptions.CollectionIsEmptyException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.WorkerAsker;

/**
 * Command 'count_by_position'. Count the collection by position.
 */
public class CountByPositionCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private WorkerAsker workerAsker;

    public CountByPositionCommand(CollectionManager collectionManager, WorkerAsker workerAsker) {
        super("count_by_position <position>", "вывести кол-во элементов, значение поля position которых равно заданному");
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
            Position position = Position.valueOf(argument.toUpperCase());
            Integer countedInfo = collectionManager.positionCountedInfo(position);
            Console.println(countedInfo);
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (IllegalArgumentException exception) {
            Console.printerror("Позиции нет в списке!");
            Console.println("Список позиций - " + Position.nameList());
        }
        return false;
    }
}