package collection;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.NoSuchElementException;


/**
 * Класс, обрабатывающий коллекцию LinkedList из HumanBeing
 */
public class HumanList {
    private LinkedList<HumanBeing> humans;
    private HandlerId handlerId;

    public HumanList() {
        humans = new LinkedList<>();
        handlerId = new HandlerId();
    }

    /**
     * Метод, проверяющий наличие id в коллекции
     */
    public boolean contains(Integer id) {
        return handlerId.contains(id);
    }

    /**
     * Метод, возвращающий LinkedList из людей
     */
    public LinkedList<HumanBeing> getHumans() {
        return humans;
    }

    /**
     * Метод, добавляющий человека в коллекцию
     */
    public void addHuman(HumanBeing human) {
        human.setId(handlerId.provideId());
        humans.add(human);
    }

    /**
     * Метод, очищающий коллекцию
     */
    public void clear() {
        handlerId.clear();
        humans.clear();
    }

    /**
     * Метод, возвращающий и удаляющий первого человека из коллекции
     */
    public HumanBeing removeHead() throws Exception{
        try {
            HumanBeing human = humans.getFirst();
            handlerId.removeId(human.getId());
            humans.removeFirst();
            return human;
        }
        catch (NoSuchElementException e) {
            throw new Exception("Коллекция пуста, первого элемента нет!");
        }
    }

    /**
     * Метод, удаляющий человека из коллекции
     */
    public void remove(HumanBeing human) {
        handlerId.removeId(human.getId());
        humans.remove(human);
    }

    /**
     * Метод, удаляющий человека из коллекции по id
     */
    public void removeById(int id) throws Exception{
        if (!handlerId.contains(id))
            throw new IOException("Такой id не найден.");
        for (HumanBeing human : humans) {
            if (human.getId() == id) {
                remove(human);
                return;
            }
        }
    }

    /**
     * Метод, заменяющий человека из коллекции по id
     */
    public void updateById(int id, HumanBeing modifiedHuman) throws Exception{
        for (int i = 0; i < humans.size(); ++i) {
            if (!handlerId.contains(id))
                throw new IOException("Такой id не найден.");
            if (humans.get(i).getId() == id) {
                humans.remove(i);
                modifiedHuman.setId(id);
                humans.add(i, modifiedHuman);
                return;
            }
        }
    }

    /**
     * Метод, удаляющий всех людей из коллекции превыщающие заданный
     */
    public void removeGreater(HumanBeing srcHuman) {
        for (int i = 0; i < humans.size(); ++i) {
            if(humans.get(i).getImpactSpeed() > srcHuman.getImpactSpeed()) {
                humans.remove(i);
                i--;
            }
        }
    }

    /**
     * Метод, сортирующий коллекцию по компаратору
     */
    public void sort(Comparator<HumanBeing> comparator) {
        humans.sort(comparator);
    }

    /**
     * Метод, сортирующий коллекцию по возрастанию
     */
    public void sort() {
        this.sort(new Comparator<HumanBeing>() {
            @Override
            public int compare(HumanBeing o1, HumanBeing o2) {
                return Float.compare(o1.getImpactSpeed(), o2.getImpactSpeed());
            }
        });
    }

    /**
     * Метод, который выводит все элементы коллекции в строковом представлении
     */
    public void print() {
        for (HumanBeing human : humans) {
            System.out.println(human.toString());
        }
    }

    /**
     * Метод, который выводит информацию о колекции
     */
    public void printInfo() {
        System.out.println("Тип коллекции: " + humans.getClass() + ", Размер: " + humans.size());
    }

    /**
     * Метод, который сортирует коллекцию, переданную в параметре, в порядке убывания
     */
    private LinkedList<HumanBeing> getDescendingHumans() {
        LinkedList<HumanBeing> result = new LinkedList<>(humans);
        result.sort(new Comparator<HumanBeing>() {
            @Override
            public int compare(HumanBeing o1, HumanBeing o2) {
                return Float.compare(o1.getImpactSpeed(), o2.getImpactSpeed()) * -1;
            }
        });
        return result;
    }

    /**
     * Метод, который выводит коллекцию в порядке убывания в строковом представлении
     */
    public void printDescending() {
        for (HumanBeing human : getDescendingHumans()) {
            System.out.println(human.toString());
        }
    }

    /**
     * Метод, который выводит все Car в порядке убывания
     */
    public void printFieldDescendingCar() {
        for (HumanBeing human : getDescendingHumans()) {
            System.out.println(human.getCar().toString());
        }
    }

    /**
     * Метод, который выводит все уникальные Car в коллекции
     */
    public void printUniqueCar() {
        HashSet<String> cars = new HashSet<>();
        for (HumanBeing human : humans) {
            if (!cars.contains(human.getCar().toString())) {
                cars.add(human.getCar().toString());
                System.out.println(human.getCar().toString());
            }
        }
    }
}
