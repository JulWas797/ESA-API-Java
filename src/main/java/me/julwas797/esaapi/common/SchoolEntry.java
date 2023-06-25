package me.julwas797.esaapi.common;

import me.julwas797.esaapi.format.PostalCodeFormatter;
import org.json.JSONObject;

import java.util.Objects;

/**
 * DTO containing data about specified school. <br>
 * Part of {@link APIEntry}
 */
public class SchoolEntry {
    /**
     * Default constructor for school DTO
     *
     * @param name        Name of the school
     * @param street      Street the school is located on
     * @param postalCode  Postal code of school
     * @param city        City the school is located in
     * @param coordinates {@link Coordinates} representing the location of the school
     */
    public SchoolEntry(String name, String street, int postalCode, String city, Coordinates coordinates) {
        this.name = name;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.coordinates = coordinates;
    }

    /**
     * Returns {@link String} containing school name
     *
     * @return Name of the school
     */
    public String getName() {
        return name;
    }

    /**
     * Returns {@link String} containing street the school is located on
     *
     * @return Street the school is located on
     */
    public String getStreet() {
        return street;
    }

    /**
     * Returns integer containing postal code of school
     *
     * @return Postal code of school
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * Returns {@link String} containing city the school is located in
     *
     * @return City the school is located in
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns {@link Coordinates} containing the school location
     *
     * @return {@link Coordinates} representing the location of the school
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Name of the school
     */
    private final String name;
    /**
     * Street the school is located on
     */
    private final String street;
    /**
     * Postal code of school
     */
    private final int postalCode;
    /**
     * City the school is located in
     */
    private final String city;
    /**
     * {@link Coordinates} representing the location of the school
     */
    private final Coordinates coordinates;

    /**
     * Alternative constructor of school location DTO from {@link org.json.JSONObject}
     *
     * @param jsonObject {@link org.json.JSONObject} containing school data.
     */
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

    /**
     * Alternative constructor, joining {@link #SchoolEntry(String, String, int, String, Coordinates)}  SchoolEntry} and {@link Coordinates#Coordinates(double, double)}  Coordinates}.
     *
     * @param name       Name of the school
     * @param street     Street the school is located on
     * @param postalCode Postal code of school
     * @param city       City the school is located in
     * @param longitude  Longitude of school location
     * @param latitude   Latitude of school location
     */
    public SchoolEntry(String name, String street, int postalCode, String city, double longitude, double latitude) {
        this(name, street, postalCode, city, new Coordinates(longitude, latitude));
    }

    /**
     * Converts the following {@link SchoolEntry} to {@link String}
     *
     * @return A serialized version of School DTO
     */
    @Override
    public String toString() {
        return "SchoolEntry{" +
                "name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }

    /**
     * Compares the equality of {@link SchoolEntry}
     *
     * @param o {@link Object}, presumably {@link SchoolEntry}
     * @return Equality status
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolEntry that = (SchoolEntry) o;
        return postalCode == that.postalCode && Objects.equals(name, that.name) && Objects.equals(street, that.street) && Objects.equals(city, that.city) && Objects.equals(coordinates, that.coordinates);
    }

    /**
     * Calculates hashcode of specific {@link SchoolEntry}
     *
     * @return integer containing hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, street, postalCode, city, coordinates);
    }
}
