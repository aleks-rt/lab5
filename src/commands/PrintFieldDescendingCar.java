package commands;

import collection.HumanList;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс команды print_field_descending_car
 */
public class PrintFieldDescendingCar implements Command {
    private int quantityParameters = 0;
    private ArrayList<String> parameters;
    private HumanList humanList;

    public PrintFieldDescendingCar(HumanList humanList) {
        this.humanList = humanList;
    }

    @Override
    public void setParameters(ArrayList<String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String getManual() {
        return "Вывести значения поля \"car\" всех элементов в порядке убывания.";
    }

    @Override
    public void execute() throws Exception {
        if (parameters.size() != quantityParameters) {
            throw new IOException("Неверное количество параметров!");
        }
        humanList.printFieldDescendingCar();
    }
}
