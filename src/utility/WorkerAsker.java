package utility;

import data.*;
import exceptions.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Ask workers fields.
 */
public class WorkerAsker {
    private final double MIN_SALARY = 0;
    private final Long MAX_X = 531L;
    private final Long MIN_Y = -958L;
    private final Long MIN_ANNUALTUROVER = 0L;

    private Scanner userScanner;
    private boolean fileMode;

    public WorkerAsker(Scanner userScanner) {
        this.userScanner = userScanner;
        fileMode = false;
    }

    /**
     * Sets a scanner to scan user input.
     *
     * @param userScanner Scanner to set.
     */
    public void setUserScanner(Scanner userScanner) {
        this.userScanner = userScanner;
    }

    /**
     * @return Scanner, which uses for user input.
     */
    public Scanner getUserScanner() {
        return userScanner;
    }

    /**
     * Sets worker asker mode to 'File Mode'.
     */
    public void setFileMode() {
        fileMode = true;
    }

    /**
     * Sets worker asker mode to 'User Mode'.
     */
    public void setUserMode() {
        fileMode = false;
    }

    /**
     * Asks a user the workers name.
     *
     * @return Workers name.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public String askName() throws IncorrectInputInScriptException {
        String name;
        while (true) {
            try {
                Console.println("Введите имя:");
                name = userScanner.nextLine().trim();
                if (fileMode) Console.println(name);
                if (name.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Имя не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Имя не может быть пустым!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return name;
    }

    /**
     * Asks a user the workers X coordinate.
     *
     * @return Workers X coordinate.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Long askX() throws IncorrectInputInScriptException {
        String strX;
        Long x;
        while (true) {
            try {
                Console.println("Введите координату X < " + (MAX_X + 1) + ":");
                strX = userScanner.nextLine().trim();
                if (fileMode) Console.println(strX);
                x = Long.parseLong(strX);
                if (x > MAX_X) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата X не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Координата X не может превышать " + MAX_X + "!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата X должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return x;
    }

    /**
     * Asks a user the workers Y coordinate.
     *
     * @return Workers Y coordinate.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Long askY() throws IncorrectInputInScriptException {
        String strY;
        Long y;
        while (true) {
            try {
                Console.println("Введите координату Y > " + (MIN_Y) + ":");
                strY = userScanner.nextLine().trim();
                if (fileMode) Console.println(strY);
                y = Long.parseLong(strY);
                if (y < MIN_Y) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата Y не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Координата Y не может быть меньше " + MIN_Y + "!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата Y должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return y;
    }
    /**
     * Asks a user the workers coordinates.
     * @return Workers coordinates.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Coordinates askCoordinates() throws IncorrectInputInScriptException {
        Long x;
        Long y;
        x = askX();
        y = askY();
        return new Coordinates(x, y);
    }
    /**
     * Asks a user the workers salary.
     * @return Workers salary.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public double askSalary() throws IncorrectInputInScriptException {
        String strSalary;
        double salary;
        while (true) {
            try {
                Console.println("Введите зарплату:");
                strSalary = userScanner.nextLine().trim();
                if (fileMode) Console.println(strSalary);
                salary = Double.parseDouble(strSalary);
                if (salary < MIN_SALARY) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Зарплата не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Зарплата должна быть больше нуля!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Зарплата должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return salary;
    }
    /**
     * Asks a user the workers position.
     * @return Workers position.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Position askPosition() throws IncorrectInputInScriptException {
        String strPosition;
        Position position;
        while (true) {
            try {
                Console.println("Список позиций - " + Position.nameList());
                Console.println("Введите позицию:");
                strPosition = userScanner.nextLine().trim();
                if (fileMode) Console.println(strPosition);
                position = Position.valueOf(strPosition.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Позиция не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalArgumentException exception) {
                Console.printerror("Позиции нет в списке!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return position;
    }
    /**
     * Asks a user the workers status.
     * @return Workers status.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Status askStatus() throws IncorrectInputInScriptException {
        String strStatus;
        Status status;
        while (true) {
            try {
                Console.println("Список статусов - " + Status.nameList());
                Console.println("Введите статус:");
                strStatus = userScanner.nextLine().trim();
                if (fileMode) Console.println(strStatus);
                status = Status.valueOf(strStatus.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Статус не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalArgumentException exception) {
                Console.printerror("Статуса нет в списке!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return status;
    }
    /**
     * Asks a user the organizations type.
     * @return Organizations type.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public OrganizationType askType() throws IncorrectInputInScriptException {
        String strType;
        OrganizationType type;
        while (true) {
            try {
                Console.println("Список типов организаций - " + OrganizationType.nameList());
                Console.println("Введите тип организации:");
                strType = userScanner.nextLine().trim();
                if (fileMode) Console.println(strType);
                type = OrganizationType.valueOf(strType.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Тип организации не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalArgumentException exception) {
                Console.printerror("Типа организации нет в списке!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return type;
    }
    /**
     * Asks a user the organizations annual turnover.
     * @return Organizations annual turnover.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Long askAnnualTurnover() throws IncorrectInputInScriptException {
        String strAnnualTurnover;
        Long annualTurnover;
        while (true) {
            try {
                Console.println("Введите ежегодный оборот > " + (MIN_ANNUALTUROVER) + ":");
                strAnnualTurnover = userScanner.nextLine().trim();
                if (fileMode) Console.println(strAnnualTurnover);
                annualTurnover = Long.parseLong(strAnnualTurnover);
                if (annualTurnover < MIN_ANNUALTUROVER) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Ежегодный оборот не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Ежегодный оборот не может быть меньше " + MIN_ANNUALTUROVER + "!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Ежегодный оборот должен быть представлен числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return annualTurnover;
    }
    /**
     * Asks a user the workers organization.
     * @return Workers organization.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Organization askOrganization() throws IncorrectInputInScriptException {
        Long annualTurnover;
        OrganizationType type;
        annualTurnover = askAnnualTurnover();
        type = askType();
        return new Organization(annualTurnover, type);
    }
    /**
     * Asks a user a question.
     * @return Answer (true/false).
     * @param question A question.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public boolean askQuestion(String question) throws IncorrectInputInScriptException {
        String finalQuestion = question + " (+/-):";
        String answer;
        while (true) {
            try {
                Console.println(finalQuestion);
                answer = userScanner.nextLine().trim();
                if (fileMode) Console.println(answer);
                if (!answer.equals("+") && !answer.equals("-")) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Ответ не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Ответ должен быть представлен знаками '+' или '-'!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return (answer.equals("+")) ? true : false;
    }
    @Override
    public String toString() {
        return "WorkerAsker (вспомогательный класс для запросов пользователю)";
    }
}
