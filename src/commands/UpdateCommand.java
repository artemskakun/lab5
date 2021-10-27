package commands;


import java.util.Date;

import data.*;
import exceptions.CollectionIsEmptyException;
import exceptions.IncorrectInputInScriptException;
import exceptions.WorkerNotFoundException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.WorkerAsker;

/**
 * Command 'update'. Updates the information about selected marine.
 */
public class UpdateCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private WorkerAsker workerAsker;

    public UpdateCommand(CollectionManager collectionManager, WorkerAsker workerAsker) {
        super("update <ID> {element}", "обновить значение элемента коллекции по ID");
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

            int id = Integer.parseInt(argument);
            Worker oldWorker = collectionManager.getById(id);
            if (oldWorker == null) throw new WorkerNotFoundException();

            String name = oldWorker.getName();
            Coordinates coordinates = oldWorker.getCoordinates();
            Date creationDate = oldWorker.getCreationDate();
            double salary = oldWorker.getSalary();
            Position position = oldWorker.getPosition();
            Status status = oldWorker.getStatus();
            Organization organization = oldWorker.getOrganization();

            collectionManager.removeFromCollection(oldWorker);

            if (workerAsker.askQuestion("Хотите изменить имя работника?")) name = workerAsker.askName();
            if (workerAsker.askQuestion("Хотите изменить координаты работника?")) coordinates = workerAsker.askCoordinates();
            if (workerAsker.askQuestion("Хотите изменить зарплату работника?")) salary = workerAsker.askSalary();
            if (workerAsker.askQuestion("Хотите изменить позицию работника?")) position = workerAsker.askPosition();
            if (workerAsker.askQuestion("Хотите изменить статус работника?")) status = workerAsker.askStatus();
            if (workerAsker.askQuestion("Хотите изменить организацию работника?")) organization = workerAsker.askOrganization();

            collectionManager.addToCollection(new Worker(
                id,
                name,
                coordinates,
                creationDate,
                salary,
                position,
                status,
                organization
            ));
            Console.println("Работник успешно изменен!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            Console.printerror("ID должен быть представлен числом!");
        } catch (WorkerNotFoundException exception) {
            Console.printerror("Работника с таким ID в коллекции нет!");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}
