package commands;

import collection.HumanList;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс команды print_unique_car
 */
public class PrintUniqueCar implements Command {
    private int quantityParameters = 0;
    private ArrayList<String> parameters;
    private HumanList humanList;

    public PrintUniqueCar(HumanList humanList) {
        this.humanList = humanList;
    }

    @Override
    public void setParameters(ArrayList<String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String getManual() {
        return "Вывести уникальные значения поля \"car\" всех элементов в коллекции.";
    }

    @Override
    public void execute() throws Exception {
        if (parameters.size() != quantityParameters) {
            throw new IOException("Неверное количество параметров!");
        }
        humanList.printUniqueCar();
    }
}
