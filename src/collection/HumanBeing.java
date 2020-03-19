package collection;

import application.HandlerInput;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Класс человека
 */
public class HumanBeing {
    private Integer id; //Поле не может быть null, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private boolean realHero;
    private boolean hasToothpick;
    private float impactSpeed;
    private WeaponType weaponType; //Поле не может быть null
    private Mood mood; //Поле может быть null
    private Car car; //Поле не может быть null

    public HumanBeing(String name, Coordinates coordinates, boolean realHero, boolean hasToothpick,
                      float impactSpeed, WeaponType weaponType, Mood mood, Car car) {
        this.name = name;
        this.coordinates = coordinates;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.weaponType = weaponType;
        this.mood = mood;
        this.car = car;
        this.creationDate = LocalDate.now();
    }

    /**
     * Конструктор класса, который считывает HumanBeing из потока ввода
     */
    public HumanBeing(HandlerInput handlerInput) {
        boolean reading = true;
        boolean flagRealHero = true;
        boolean flagHasToothpick = true;
        boolean flagImpactSpeed = true;
        while (reading){
            try {
                if (name == null) {
                    System.out.println("Введите значение поля \"name\" одним словом.");
                    ArrayList<String> data = handlerInput.getData();
                    setName(data);
                }

                if (coordinates == null) {
                    System.out.println("Введите значение поля \"coordinates\" -  X и Y через пробел. " +
                                       "Если числа дробные, то их надо записать через ТОЧКУ!");
                    ArrayList<String> data = handlerInput.getData();
                    setCoordinates(data);
                }

                if (flagRealHero) {
                    System.out.println("Введите значение поля \"realHero\". Принимаемые значения: true, false.");
                    ArrayList<String> data = handlerInput.getData();
                    setRealHero(data);
                    flagRealHero = false;
                }

                if (flagHasToothpick) {
                    System.out.println("Введите значение поля \"hasToothpick\". Принимаемые значения: true, false.");
                    ArrayList<String> data = handlerInput.getData();
                    setHasToothpick(data);
                    flagHasToothpick = false;
                }

                if (flagImpactSpeed) {
                    System.out.println("Введите значение поля \"impactSpeed\". Если число дробное, то его надо записать через ТОЧКУ!");
                    ArrayList<String> data = handlerInput.getData();
                    setImpactSpeed(data);
                    flagImpactSpeed = false;
                }

                if (weaponType == null) {
                    System.out.println("Введите значение поля \"weaponType\". Принимаемые значения:");
                    System.out.println(Arrays.toString(WeaponType.values()));
                    ArrayList<String> data = handlerInput.getData();
                    setWeaponType(data);
                }

                if (mood == null) {
                    System.out.println("Введите значение поля \"mood\". Принимаемые значения:");
                    System.out.println(Arrays.toString(Mood.values()));
                    ArrayList<String> data = handlerInput.getData();
                    setMood(data);
                }

                if (car == null) {
                    System.out.println("Введите значение поля \"name\" одним словом для объекта Car.");
                    ArrayList<String> data = handlerInput.getData();
                    setCar(data);
                }
                reading = false;

            }
            catch (NullPointerException e) {
                System.out.println("Вы ничего не ввели!");
            }
            catch (NumberFormatException e) {
                System.out.println("Некорректный ввод числа!");
            }
            catch (IllegalArgumentException e) {
                System.out.println("Введенное значение не подходит под перечень!");
            }
            catch (IOException e) {
                System.out.println("Некорректный ввод!");
            }
            catch (Exception e) {
                System.out.println("Вы выявили новый баг! Ну что же, будем фиксить) " + e.getMessage());
            }
        }
        this.creationDate = LocalDate.now();
    }

    private void setName(ArrayList<String> data) throws IOException {
        if (data.size() != 1) {
            throw new IOException();
        }
        this.name = data.get(0);
    }

    private void setCoordinates(ArrayList<String> data) throws IOException {
        if (data.size() != 2){
            throw new IOException();
        }
        this.coordinates = new Coordinates(Float.parseFloat(data.get(0)), Float.parseFloat(data.get(1)));
    }

    private void setRealHero(ArrayList<String> data) throws IOException {
        if (data.size() != 1) {
            throw new IOException();
        }
        if (!data.get(0).toLowerCase().equals("false") && !data.get(0).toLowerCase().equals("true"))
            throw new IllegalArgumentException();
        this.realHero = Boolean.parseBoolean(data.get(0));
    }

    private void setHasToothpick(ArrayList<String> data) throws IOException {
        if (data.size() != 1) {
            throw new IOException();
        }
        if (!data.get(0).toLowerCase().equals("false") && !data.get(0).toLowerCase().equals("true"))
            throw new IllegalArgumentException();
        this.hasToothpick = Boolean.parseBoolean(data.get(0));
    }

    private void setImpactSpeed(ArrayList<String> data) throws IOException {
        if (data.size() != 1) {
            throw new IOException();
        }
        this.impactSpeed = Float.parseFloat(data.get(0));
    }

    private void setWeaponType(ArrayList<String> data) throws IOException {
        if (data.size() != 1) {
            throw new IOException();
        }
        this.weaponType = WeaponType.valueOf(data.get(0).toUpperCase());
    }

    private void setMood(ArrayList<String> data) throws IOException {
        if (data.size() != 1) {
            throw new IOException();
        }
        this.mood = Mood.valueOf(data.get(0).toUpperCase().toUpperCase());
    }

    private void setCar(ArrayList<String> data) throws IOException {
        if (data.size() != 1) {
            throw new IOException();
        }
        this.car = new Car(data.get(0));
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public boolean getRealHero() {
        return realHero;
    }

    public boolean getHasToothpick() {
        return hasToothpick;
    }

    public float getImpactSpeed() {
        return impactSpeed;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public Mood getMood() {
        return mood;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return  "HumanBeing [id=" + id + ", \n" +
                "         name=" + name + ", \n" +
                "         coordinates=" + coordinates.toString() + ", \n" +
                "         creationDate=" + creationDate.toString() + ", \n" +
                "         realHero=" + realHero + ", \n" +
                "         hasToothpick=" + hasToothpick + ", \n" +
                "         impactSpeed=" + impactSpeed + ", \n" +
                "         weaponType=" + weaponType + ", \n" +
                "         mood=" + mood + ", \n" +
                "         car= " + car.toString() + "]";
    }
}