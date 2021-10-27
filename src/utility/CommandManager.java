package utility;

import commands.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Operates the commands.
 */
public class CommandManager {

    private List<Command> commands = new ArrayList<>();
    private Command helpCommand;
    private Command infoCommand;
    private Command showCommand;
    private Command addCommand;
    private Command updateCommand;
    private Command removeByIdCommand;
    private Command clearCommand;
    private Command saveCommand;
    private Command exitCommand;
    private Command executeScriptCommand;
    private Command addIfMaxCommand;
    private Command addIfMinCommand;
    private Command removeLowerCommand;
    private Command removeByStatusCommand;
    private Command countByPositionCommand;
    private Command printAscendingCommand;

    public CommandManager(Command helpCommand, Command infoCommand, Command showCommand, Command addCommand, Command updateCommand,
                          Command removeByIdCommand, Command clearCommand, Command saveCommand, Command exitCommand, Command executeScriptCommand,
                          Command addIfMinCommand, Command addIfMaxCommand, Command removeLowerCommand, Command removeByStatusCommand,
                          Command countByPositionCommand, Command printAscendingCommand) {
        this.helpCommand = helpCommand;
        this.infoCommand = infoCommand;
        this.showCommand = showCommand;
        this.addCommand = addCommand;
        this.updateCommand = updateCommand;
        this.removeByIdCommand = removeByIdCommand;
        this.clearCommand = clearCommand;
        this.saveCommand = saveCommand;
        this.exitCommand = exitCommand;
        this.executeScriptCommand = executeScriptCommand;
        this.addIfMinCommand = addIfMinCommand;
        this.addIfMaxCommand = addIfMaxCommand;
        this.removeLowerCommand = removeLowerCommand;
        this.removeByStatusCommand = removeByStatusCommand;
        this.countByPositionCommand = countByPositionCommand;
        this.printAscendingCommand = printAscendingCommand;

        // commands.add(helpCommand);
        commands.add(infoCommand);
        commands.add(showCommand);
        commands.add(addCommand);
        commands.add(updateCommand);
        commands.add(removeByIdCommand);
        commands.add(clearCommand);
        commands.add(saveCommand);
        commands.add(exitCommand);
        commands.add(executeScriptCommand);
        commands.add(addIfMinCommand);
        commands.add(addIfMaxCommand);
        commands.add(removeLowerCommand);
        commands.add(removeByStatusCommand);
        commands.add(countByPositionCommand);
        commands.add(printAscendingCommand);
    }


    /**
     * @return List of manager's commands.
     */
    public List<Command> getCommands() {
        return commands;
    }


    /**
     * Prints that command is not found.
     * @param command Comand, which is not found.
     * @return Command exit status.
     */
    public boolean noSuchCommand(String command) {
        Console.println("Команда '" + command + "' не найдена. Наберите 'help' для справки.");
        return false;
    }

    /**
     * Prints info about the all commands.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean help(String argument) {
        if (helpCommand.execute(argument)) {
            for (Command command : commands) {
                Console.printtable(command.getName(), command.getDescription());
            }
            return true;
        } else return false;
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean info(String argument) {
        return infoCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean show(String argument) {
        return showCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean add(String argument) {
        return addCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean update(String argument) {
        return updateCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean removeById(String argument) {
        return removeByIdCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean clear(String argument) {
        return clearCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean save(String argument) {
        return saveCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean exit(String argument) {
        return exitCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean executeScript(String argument) {
        return executeScriptCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean addIfMin(String argument) {
        return addIfMinCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean addIfMax(String argument) {
        return addIfMaxCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean removeLower(String argument) {
        return removeLowerCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean removeByStatus(String argument) {
        return removeByStatusCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean countByPosition(String argument) {
        return countByPositionCommand.execute(argument);
    }
    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean printAscending(String argument) {
        return printAscendingCommand.execute(argument);
    }

    @Override
    public String toString() {
        return "CommandManager (вспомогательный класс для работы с командами)";
    }
}