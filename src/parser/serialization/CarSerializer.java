package parser.serialization;

import collection.Car;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;


/**
 * Класс сериализующий Car
 */
public class CarSerializer implements JsonSerializer<Car> {

    /**
     * Метод сериализующий Car
     */
    @Override
    public JsonElement serialize(Car car, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("name", car.getName());

        return jsonObject;
    }
}
