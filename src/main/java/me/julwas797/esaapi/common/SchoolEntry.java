package me.julwas797.esaapi.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import me.julwas797.esaapi.format.PostalCodeFormatter;
import org.json.JSONObject;

@Data
@AllArgsConstructor
public class SchoolEntry {
    private final String name;
    private final String street;
    private final int postalCode;
    private final String city;
    private final Coordinates coordinates;

    public SchoolEntry(JSONObject jsonObject) {
        this(
                jsonObject.optString("name"),
                jsonObject.opt("street").toString(),
                PostalCodeFormatter.getInstance().format(jsonObject),
                jsonObject.optString("city"),
                jsonObject.optDouble("longitude"),
                jsonObject.optDouble("latitude")
        );
    }

    public SchoolEntry(String name, String street, int postalCode, String city, double longitude, double latitude) {
        this(name, street, postalCode, city, new Coordinates(longitude, latitude));
    }
}
