package me.julwas797.esaapi.api;

/**
 * Interface that provides base of air pollution data sources / repositories.
 * @see me.julwas797.esaapi.api.impl.APIAutoDataSource
 * @see me.julwas797.esaapi.api.impl.APIDataSource
 */
public interface DataSource {
    /**
     * Base method that should provide ability to refresh air pollution data.
     */
    void refreshEntries();
}
