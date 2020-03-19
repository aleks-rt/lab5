package parser.serialization;

import collection.Coordinates;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * Класс сериализующий Coordinates
 */
public class CoordinatesSerializer implements JsonSerializer<Coordinates> {

    /**
     * Метод сериализующий Coordinates
     */
    @Override
    public JsonElement serialize(Coordinates coordinates, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("x", coordinates.getX());
        jsonObject.addProperty("y", coordinates.getY());

        return jsonObject;
    }
}
