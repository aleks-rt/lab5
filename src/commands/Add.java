package commands;

import application.HandlerInput;
import collection.HumanBeing;
import collection.HumanList;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Класс команды add
 */
public class Add implements Command {
    private int quantityParameters = 0;
    private ArrayList<String> parameters;
    private HandlerInput handlerInput;
    private HumanList humanList;

    public Add(HandlerInput handlerInput, HumanList humanList) {
        this.handlerInput = handlerInput;
        this.humanList = humanList;
    }

    @Override
    public void setParameters(ArrayList<String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String getManual() {
        return "Добавить новый элемент в коллекцию. Параметры: {element}.";
    }

    @Override
    public void execute() throws Exception {
        if (parameters.size() != quantityParameters) {
            throw new IOException("Неверное количество параметров!");
        }
        humanList.addHuman(new HumanBeing(handlerInput));
    }
}
