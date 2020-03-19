package commands;

import application.HandlerInput;
import collection.HumanBeing;
import collection.HumanList;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс команды remove_greater
 */
public class RemoveGreater implements Command{
    private int quantityParameters = 0;
    private ArrayList<String> parameters;
    private HandlerInput handlerInput;
    private HumanList humanList;

    public RemoveGreater(HandlerInput handlerInput, HumanList humanList) {
        this.handlerInput = handlerInput;
        this.humanList = humanList;
    }

    @Override
    public void setParameters(ArrayList<String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String getManual() {
        return "Удалить из коллекции элементы, превышающие заданный. Параметры: {element}.";
    }

    @Override
    public void execute() throws Exception {
        if (parameters.size() != quantityParameters) {
            throw new IOException("Неверное количество параметров!");
        }
        humanList.removeGreater(new HumanBeing(handlerInput));
    }
}
