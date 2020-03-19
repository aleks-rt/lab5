package parser.deserialization;

import collection.*;
import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Класс десеарилизующий HumanBeing
 */
public class HumanDeserializer implements JsonDeserializer<HumanBeing> {

    /**
     * Метод десеарилизующий HumanBeing
     */
    @Override
    public HumanBeing deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        HumanBeing human = new HumanBeing(jsonObject.get("name").getAsString(),
                (Coordinates) jsonDeserializationContext.deserialize(jsonObject.get("coordinates"), Coordinates.class),
                jsonObject.get("realHero").getAsBoolean(),
                jsonObject.get("hasToothpick").getAsBoolean(),
                jsonObject.get("impactSpeed").getAsFloat(),
                WeaponType.valueOf(jsonObject.get("weaponType").getAsString()),
                Mood.valueOf(jsonObject.get("mood").getAsString()),
                (Car) jsonDeserializationContext.deserialize(jsonObject.get("car"), Car.class));
        if(human.getCoordinates() == null || human.getCar() == null)
            throw new JsonParseException("Некорректный json файл!");
        return human;
    }
}
