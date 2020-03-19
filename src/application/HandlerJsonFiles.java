package application;

import java.io.*;

/**
 * Класс, который производит работу с Json файлами
 */
public class HandlerJsonFiles {

    /**
     * Метод, который считывает json файл
     */
    public static String readFile(String[] args) throws IOException {
        if(args.length == 0)
            throw  new IOException("Вы не ввели имя файла!");
        if(args.length > 1)
            System.out.println("Путь состоит из нескольких значений, поэтому обрабатывается только первый (" + args[0] + ").");
        if(!args[0].substring(args[0].length() - 5, args[0].length()).equals(".json"))
            throw new IOException("Этот файл не .json.");
        String data = "";
        String line;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        while ((line = bufferedReader.readLine()) != null) {
            data = data + line + "\n";
        }
        bufferedReader.close();
        return data;
    }

    /**
     * Метод, который записывает полученный json файл
     */
    public static void saveFile(String[] args, String data) throws IOException{
        String path = args[0].substring(0, args[0].length() - 5);
        path = path + "_output.json";
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(data);
        fileWriter.close();
        System.out.println("Файл " + path + " сохранен!");
    }
}
