package me.julwas797.esaapi.api.impl;

/**
 * An extension of {@link APIDataSource}, providing automatic refresh in initialization.
 */
public class APIAutoDataSource extends APIDataSource {
    /**
     * Parameterless constructor that preforms data refreshing upon being called.
     */
    public APIAutoDataSource() {
        refreshEntries();
    }
}
