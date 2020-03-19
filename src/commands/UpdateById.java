package commands;

import application.HandlerInput;
import collection.HumanBeing;
import collection.HumanList;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс команды update
 */
public class UpdateById implements Command {
    private int quantityParameters = 1;
    private ArrayList<String> parameters;
    private HandlerInput handlerInput;
    private HumanList humanList;

    public UpdateById(HandlerInput handlerInput, HumanList humanList) {
        this.handlerInput = handlerInput;
        this.humanList = humanList;
    }

    @Override
    public void setParameters(ArrayList<String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String getManual() {
        return "Обновить значение элемента коллекции по полю \"id\". Параметры: {element}.";
    }

    @Override
    public void execute() throws Exception {
        if (parameters.size() != quantityParameters){
            throw new IOException("Неверное количество параметров!");
        }
        try{
            if (!humanList.contains(Integer.parseInt(parameters.get(0))))
                throw new IOException("Такой id не найден.");
            humanList.updateById(Integer.parseInt(parameters.get(0)), new HumanBeing(handlerInput));
        }
        catch (NumberFormatException e) {
            throw new NullPointerException("Некорректный ввод id!");
        }
    }
}
