package application;

import collection.HumanList;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import commands.*;
import parser.Parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс приложения
 */
public class ConsoleApplication {
    private String[] args;

    private HumanList humanList;
    private HandlerInput handlerInput;
    private HandlerCommands handlerCommands;

    private Command close;
    private Command help;
    private Command info;
    private Command show;
    private Command clear;
    private Command save;
    private Command removeHead;
    private Command printDescending;
    private Command printUniqueCar;
    private Command printFieldDescendingCar;
    private Command history;
    private Command removeById;
    private Command executeScript;
    private Command add;
    private Command updateById;
    private Command removeGreater;

    public ConsoleApplication(String[] args) {
        this.args = args;
    }

    /**
     * Инициализация приложения
     */
    public void initialization() throws IOException, JsonParseException {
        handlerCommands = new HandlerCommands();
        handlerInput = new HandlerInput();

        String data = HandlerJsonFiles.readFile(args);
        humanList = Parser.deserialize(data);
        System.out.println("Коллекция заполнена.");

        close = new Close();
        help = new Help(handlerCommands);
        info = new Info(humanList);
        show = new Show(humanList);
        clear = new Clear(humanList);
        save = new Save(humanList, args);
        removeHead = new RemoveHead(humanList);
        printDescending = new PrintDescending(humanList);
        printUniqueCar = new PrintUniqueCar(humanList);
        printFieldDescendingCar = new PrintFieldDescendingCar(humanList);
        history = new History(handlerCommands);
        removeById = new RemoveById(humanList);
        executeScript = new ExecuteScript(handlerInput);
        add = new Add(handlerInput, humanList);
        updateById = new UpdateById(handlerInput, humanList);
        removeGreater = new RemoveGreater(handlerInput, humanList);

        handlerCommands.setCommand("exit", close);
        handlerCommands.setCommand("help", help);
        handlerCommands.setCommand("info", info);
        handlerCommands.setCommand("show", show);
        handlerCommands.setCommand("clear", clear);
        handlerCommands.setCommand("save", save);
        handlerCommands.setCommand("remove_head", removeHead);
        handlerCommands.setCommand("print_descending", printDescending);
        handlerCommands.setCommand("print_unique_car", printUniqueCar);
        handlerCommands.setCommand("print_field_descending_car", printFieldDescendingCar);
        handlerCommands.setCommand("history", history);
        handlerCommands.setCommand("remove_by_id", removeById);
        handlerCommands.setCommand("execute_script", executeScript);
        handlerCommands.setCommand("add", add);
        handlerCommands.setCommand("update", updateById);
        handlerCommands.setCommand("remove_greater", removeGreater);

        System.out.println("Консольное приложение запущено.");

    }

    /**
     * Метод запуска приложения
     */
    public void run() throws IOException{
        System.out.println("Введите \"help\" для просмотра перечня команд.\nВводите команды:");
        while (true) {
            try {
                ArrayList<String> data;
                if ((data = handlerInput.getData()) != null) {
                    handlerCommands.executeCommand(data);
                }
            }
            catch (NullPointerException e) {
                System.out.println("Не найдена такая команда! Введите \"help\" для просмотра перечня команд.");
            }

            catch (FileNotFoundException e) {
                System.out.println("Не удалось записать файл. Возможно, нет прав на запись.");
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
