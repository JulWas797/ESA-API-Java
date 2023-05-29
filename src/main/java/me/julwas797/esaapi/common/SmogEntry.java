package me.julwas797.esaapi.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.json.JSONObject;

@Data
@AllArgsConstructor
public class SmogEntry {
    private final double averageHumidity;
    private final double averagePressure;
    private final double averageTemperature;
    private final double averagePm10;
    private final double averagePm25;

    public SmogEntry(JSONObject jsonObject) {
        this(
                jsonObject.optDouble("humidity_avg"),
                jsonObject.optDouble("pressure_avg"),
                jsonObject.optDouble("temperature_avg"),
                jsonObject.optDouble("pm10_avg"),
                jsonObject.optDouble("pm25_avg")
        );
    }
}
