import application.ConsoleApplication;
import com.google.gson.JsonParseException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ConsoleApplication consoleApplication = new ConsoleApplication(args);
        try {
            consoleApplication.initialization();
            consoleApplication.run();
        }
        catch (JsonParseException | NullPointerException e) {
            System.out.println("Некорректный json файл!");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
