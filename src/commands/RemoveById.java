package commands;

import collection.HumanList;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс команды remove_by_id
 */
public class RemoveById implements Command {

    private int quantityParameters = 1;
    private ArrayList<String> parameters;
    private HumanList humanList;

    public RemoveById(HumanList humanList) {
        this.humanList = humanList;
    }

    @Override
    public void setParameters(ArrayList<String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String getManual() {
        return "Удалить элемент из коллекции по его \"id\". Параметры: id.";
    }

    @Override
    public void execute() throws Exception {
        if (parameters.size() != quantityParameters) {
            throw new IOException("Неверное количество параметров!");
        }
        try {
            humanList.removeById(Integer.parseInt(parameters.get(0)));
        }
        catch (NumberFormatException e) {
            throw new NullPointerException("Некорректный ввод id!");
        }
    }
}
