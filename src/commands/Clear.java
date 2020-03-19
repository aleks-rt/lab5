package commands;

import collection.HumanList;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс команды clear
 */
public class Clear implements Command {
    private int quantityParameters = 0;
    private ArrayList<String> parameters;
    private HumanList humanList;

    public Clear(HumanList humanList) {
        this.humanList = humanList;
    }

    @Override
    public void setParameters(ArrayList<String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String getManual() {
        return "Очистить коллекцию.";
    }

    @Override
    public void execute() throws Exception {
        if (parameters.size() > quantityParameters) {
            throw new IOException("Неверное количество параметров!");
        }
        humanList.clear();
    }
}
