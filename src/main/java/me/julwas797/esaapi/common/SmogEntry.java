package me.julwas797.esaapi.common;

import org.json.JSONObject;

import java.util.Objects;

/**
 * DTO containing data about air pollution.
 * <br>
 * Part of {@link me.julwas797.esaapi.common.APIEntry}
 */
public class SmogEntry {

    /**
     * Average humidity percentage
     */
    private final double averageHumidity;
    /**
     * Average air pressure in hectopascals
     */
    private final double averagePressure;
    /**
     * Average temperature in Celsius degrees
     */
    private final double averageTemperature;
    /**
     * Average amount PM<sub>2.5</sub> in micrograms per square meter of air
     */
    private final double averagePm10;
    /**
     * Average amount PM<sub>10</sub> in micrograms per square meter of air
     */
    private final double averagePm25;

    /**
     * Alternative constructor of air pollution DTO from {@link org.json.JSONObject}
     *
     * @param jsonObject {@link org.json.JSONObject} containing air pollution data.
     */
    public SmogEntry(JSONObject jsonObject) {
        this(
                jsonObject.optDouble("humidity_avg"),
                jsonObject.optDouble("pressure_avg"),
                jsonObject.optDouble("temperature_avg"),
                jsonObject.optDouble("pm10_avg"),
                jsonObject.optDouble("pm25_avg")
        );
    }

    public SmogEntry(double averageHumidity, double averagePressure, double averageTemperature, double averagePm10, double averagePm25) {
        this.averageHumidity = averageHumidity;
        this.averagePressure = averagePressure;
        this.averageTemperature = averageTemperature;
        this.averagePm10 = averagePm10;
        this.averagePm25 = averagePm25;
    }

    /**
     * Method to obtain average humidity percentage
     *
     * @return Average humidity percentage
     */
    public double getAverageHumidity() {
        return averageHumidity;
    }

    /**
     * Method to obtain average air pressure in hectopascals
     *
     * @return Average air pressure in hectopascals
     */
    public double getAveragePressure() {
        return averagePressure;
    }

    /**
     * Method to obtain average temperature in Celsius degrees
     *
     * @return Average temperature in Celsius degrees
     */
    public double getAverageTemperature() {
        return averageTemperature;
    }

    /**
     * Method to obtain average amount PM<sub>2.5</sub> in micrograms per square meter of air
     *
     * @return Average amount PM<sub>2.5</sub> in micrograms per square meter of air
     */
    public double getAveragePm10() {
        return averagePm10;
    }

    /**
     * Method to obtain average amount PM<sub>10</sub> in micrograms per square meter of air
     *
     * @return Average amount PM<sub>10</sub> in micrograms per square meter of air
     */
    public double getAveragePm25() {
        return averagePm25;
    }

    /**
     * Converts the following {@link SmogEntry} to {@link String}
     *
     * @return A serialized version of Air pollution DTO
     */
    @Override
    public String toString() {
        return "SmogEntry{" +
                "averageHumidity=" + averageHumidity +
                ", averagePressure=" + averagePressure +
                ", averageTemperature=" + averageTemperature +
                ", averagePm10=" + averagePm10 +
                ", averagePm25=" + averagePm25 +
                '}';
    }

    /**
     * Compares the equality of {@link SmogEntry}
     *
     * @param o {@link Object}, presumably {@link SmogEntry}
     * @return Equality status
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmogEntry smogEntry = (SmogEntry) o;
        return Double.compare(smogEntry.averageHumidity, averageHumidity) == 0 && Double.compare(smogEntry.averagePressure, averagePressure) == 0 && Double.compare(smogEntry.averageTemperature, averageTemperature) == 0 && Double.compare(smogEntry.averagePm10, averagePm10) == 0 && Double.compare(smogEntry.averagePm25, averagePm25) == 0;
    }

    /**
     * Calculates hashcode of specific {@link SmogEntry}
     *
     * @return integer containing hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(averageHumidity, averagePressure, averageTemperature, averagePm10, averagePm25);
    }
}
