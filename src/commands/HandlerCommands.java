package commands;

import java.util.*;

/**
 * Класс обработчика команд
 */
public class HandlerCommands {
    private HashMap<String, Command> commands;
    private LinkedList<String> lastCommands = new LinkedList<>();

    public HandlerCommands() {
        commands = new HashMap<>();
    }

    /**
     * Метод добавления команды
     */
    public void setCommand(String key, Command command) {
        commands.put(key, command);
    }

    /**
     * Метод вызова команды
     */
    public void executeCommand(ArrayList<String> data) throws Exception{
        String name = data.get(0);
        data.remove(0);
        commands.get(name).setParameters(data);
        System.out.println(name + ": ");
        commands.get(name).execute();
        System.out.println(name + " complete!\n");
        if (lastCommands.size() > 7) {
            lastCommands.removeFirst();
        }
        lastCommands.addLast(name);
    }

    public void printHistory() {
        for (String command : lastCommands) {
            System.out.println(command);
        }
    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }

}
