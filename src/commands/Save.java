package commands;

import application.HandlerJsonFiles;
import collection.HumanList;
import parser.Parser;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс команды save
 */
public class Save implements Command {
    private int quantityParameters = 0;
    private ArrayList<String> parameters;
    private HumanList humanList;
    private String[] args;

    public Save(HumanList humanList, String[] args) {
        this.humanList = humanList;
        this.args = args;
    }

    @Override
    public void setParameters(ArrayList<String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String getManual() {
        return "Сохранить коллекцию в файл. (Название файла будет inputFile_output.json).";
    }

    @Override
    public void execute() throws Exception {
        if (parameters.size() != quantityParameters) {
            throw new IOException("Неверное количество параметров!");
        }
        HandlerJsonFiles.saveFile(args, Parser.serialize(humanList));
    }
}
