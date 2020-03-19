package application;

import java.io.InputStream;

/**
 * Класс, хранящий InputStream и его имя
 */
public class NamedInputStream {
    private String name;
    private InputStream inputStream;

    public NamedInputStream(String name, InputStream inputStream) {
        this.name = name;
        this.inputStream = inputStream;
    }

    public String getName() {
        return name;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
