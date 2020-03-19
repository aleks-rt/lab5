package parser.deserialization;

import collection.Coordinates;
import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Класс десеарилизующий Coordinates
 */
public class CoordinatesDeserializer implements JsonDeserializer<Coordinates> {

    /**
     * Класс десеарилизующий Coordinates
     */
    @Override
    public Coordinates deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        return new Coordinates(jsonObject.get("x").getAsFloat(), jsonObject.get("y").getAsFloat());
    }
}
