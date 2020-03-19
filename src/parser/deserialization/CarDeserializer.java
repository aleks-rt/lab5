package parser.deserialization;

import collection.Car;
import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Класс десеарилизующий Car
 */
public class CarDeserializer implements JsonDeserializer<Car> {

    /**
     * Метод десеарилизующий Car
     */
    @Override
    public Car deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        return new Car(jsonObject.get("name").getAsString());
    }
}
