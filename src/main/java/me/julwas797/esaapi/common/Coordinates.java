package me.julwas797.esaapi.common;

import java.util.Objects;

/**
 * Basic implementation of longitude/latitude coordinate system used in {@link SchoolEntry}
 */
public class Coordinates {
    /**
     * Longitude.
     */
    private final double longitude;
    /**
     * Latitude.
     */
    private final double latitude;

    /**
     * Default constructor of {@link Coordinates}
     *
     * @param longitude longitude coordinates
     * @param latitude latitude coordinates
     */
    public Coordinates(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * Returns the longitude coordinates
     *
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Returns the latitude coordinates
     *
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Converts the following {@link Coordinates} to {@link String}
     *
     * @return A serialized version of coordinates
     */
    @Override
    public String toString() {
        return "Coordinates{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    /**
     * Compares the equality of {@link Coordinates}
     *
     * @param o {@link Object}, presumably {@link Coordinates}
     * @return Equality status
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Double.compare(that.longitude, longitude) == 0 && Double.compare(that.latitude, latitude) == 0;
    }

    /**
     * Calculates hashcode of specific {@link Coordinates}
     *
     * @return integer containing hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(longitude, latitude);
    }
}
