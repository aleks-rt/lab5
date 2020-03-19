package application;

import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Класс, обрабатывающий ввод в приложении
 */
public class HandlerInput {
    private BufferedReader bufferedReader;
    private Stack<Pair<String, InputStream>> inputStreamStack;
    private HashSet<String> paths;

    public HandlerInput() throws IOException{
        inputStreamStack = new Stack<>();
        paths = new HashSet<>();
        pushInputStream(new Pair<String, InputStream>(null, System.in));
    }

    /**
     * Метод, который добавляет новый ImputStream в Stack и открывает его
     */
    private void pushInputStream(Pair<String, InputStream> inputStream) throws IOException {
        inputStreamStack.push(inputStream);
        bufferedReader = new BufferedReader(new InputStreamReader(inputStreamStack.peek().getValue()));
    }

    /**
     * Метод, который убирает отработанный ImputStream из Stack и открывает следующий
     */
    private void popInputStream() throws IOException{
        paths.remove(inputStreamStack.peek().getKey());
        inputStreamStack.pop();
        bufferedReader = new BufferedReader(new InputStreamReader(inputStreamStack.peek().getValue()));
    }

    /**
     * Метод, который добавляет файл в Stack новй файл и открывает его для чтения
     */
    public void pushFileStream(String path) throws IOException{
        path = new File(path).getCanonicalPath();
        if (paths.contains(path)) {
            throw new IOException("Вы вызываете команду, из-за которого произойдет рекурсия! Остановка программы!");
        }
        pushInputStream(new Pair<String, InputStream>(path, new FileInputStream(path)));
        paths.add(path);
    }

    /**
     * Метод, считывает данные с активного ImputStream
     */
    public ArrayList<String> getData() throws IOException {
        String srcData;
        ArrayList<String> data = new ArrayList<>();
        if ((srcData = bufferedReader.readLine()) != null) {
            srcData = srcData.trim();
            srcData = srcData + " ";
            if (srcData.equals(" ")) {
                return null;
            }
            char[] str = srcData.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < str.length; ++i) {
                if(str[i] != ' ') {
                    stringBuilder.append(str[i]);
                }
                else if (str[i - 1] != ' ') {
                    data.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
            }
        }
        else {
            data = null;
            if(inputStreamStack.peek().getKey() != null) {
                popInputStream();
            }
        }
        return data;
    }
}
