package commands;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс команды history
 */
public class History implements Command {
    private HandlerCommands handlerCommands;
    private int quantityParameters = 0;
    private ArrayList<String> parameters;

    public History(HandlerCommands handlerCommands) {
        this.handlerCommands = handlerCommands;
    }

    @Override
    public void setParameters(ArrayList<String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String getManual() {
        return "Вывести последние 7 команд (без аргументов).";
    }

    @Override
    public void execute() throws Exception {
        if (parameters.size() != quantityParameters) {
            throw new IOException("Неверное количество параметров!");
        }
        handlerCommands.printHistory();
    }
}
