package me.julwas797.esaapi.common;

import java.util.Objects;

/**
 * DTO joining {@link SchoolEntry} and {@link SmogEntry}
 */
@SuppressWarnings("unused")
public class APIEntry {
    /**
     * {@link SchoolEntry} associated with specific air pollution data
     */
    private final SchoolEntry schoolEntry;
    /**
     * {@link SmogEntry} associated with specific school
     */
    private final SmogEntry smogEntry;

    /**
     * Default constructor of {@link APIEntry}
     *
     * @param schoolEntry Associated {@link SchoolEntry}
     * @param smogEntry   Associated {@link SmogEntry}
     */
    public APIEntry(SchoolEntry schoolEntry, SmogEntry smogEntry) {
        this.schoolEntry = schoolEntry;
        this.smogEntry = smogEntry;
    }

    /**
     * Returns {@link SchoolEntry} associated with specific air pollution data
     *
     * @return Associated {@link SchoolEntry}
     */
    public SchoolEntry getSchoolEntry() {
        return schoolEntry;
    }

    /**
     * Returns {@link SmogEntry} associated with specific air pollution data
     *
     * @return Associated {@link SmogEntry}
     */
    public SmogEntry getSmogEntry() {
        return smogEntry;
    }

    /**
     * Converts the following {@link APIEntry} to {@link String}
     *
     * @return A serialized version of current entry
     */
    @Override
    public String toString() {
        return "APIEntry{" +
                "schoolEntry=" + schoolEntry +
                ", smogEntry=" + smogEntry +
                '}';
    }

    /**
     * Compares the equality of {@link APIEntry}
     *
     * @param o {@link Object}, presumably {@link APIEntry}
     * @return Equality status
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        APIEntry apiEntry = (APIEntry) o;
        return Objects.equals(schoolEntry, apiEntry.schoolEntry) && Objects.equals(smogEntry, apiEntry.smogEntry);
    }

    /**
     * Calculates hashcode of specific {@link APIEntry}
     *
     * @return integer containing hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(schoolEntry, smogEntry);
    }
}
