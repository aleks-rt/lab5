package collection;


/**
 * Класс машины
 */
public class Car {
    private String name; //Поле не может быть null

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Car [name=" + name + "]";
    }
}