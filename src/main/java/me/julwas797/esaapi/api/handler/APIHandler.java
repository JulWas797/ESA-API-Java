package me.julwas797.esaapi.api.handler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

/**
 * Main API Data handler, implemented using Singleton pattern
 *
 * @see #getInstance()
 */
public class APIHandler {

    /**
     * Singleton instance
     */
    private static final APIHandler INSTANCE = new APIHandler();

    /**
     * This method is used to obtain the singleton instance of itself.
     *
     * @return A singleton instance of {@link APIHandler}
     */
    public static APIHandler getInstance() {
        return INSTANCE;
    }

    /**
     * Private constructor (per se Singleton implementation)
     */
    private APIHandler() {
    }

    /**
     * Method used to convert raw JSON data ({@link #getRawJsonData()}) into {@link JSONArray}
     *
     * @param source {@link String} containing raw API Data.
     * @return {@link JSONArray} containing formatted data or null if source is empty.
     */
    public JSONArray getJsonApiDataArray(String source) {
        if (source == null) {
            return null;
        }
        else {
            JSONObject formattedApiData = new JSONObject(source);
            return formattedApiData.optJSONArray("smog_data");
        }
    }

    /**
     * Alternative version {@link #getJsonApiDataArray(String)} that automatically fetches data from {@link #getRawJsonData()}
     *
     * @return {@link JSONArray} containing formatted data or null if source is empty.
     */
    public JSONArray getJsonApiDataArray() {
        return getJsonApiDataArray(getRawJsonData());
    }

    /**
     * Method used to join data obtained using {@link #getReader()} into {@link String}.
     *
     * @return {@link String} containing raw API Data
     */
    public String getRawJsonData() {
        String lines = null;
        try (BufferedReader apiReader = getReader()) {
            lines = apiReader.lines().collect(Collectors.joining());
        } catch (Exception ignored) {
        }
        return lines;
    }

    /**
     * Method used to obtain {@link BufferedReader} of raw API Data.
     *
     * @throws IOException Throws {@link IOException} if fails to read data.
     * @return {@link BufferedReader} from raw API Data.
     */
    protected BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(new URL("https://public-esa.ose.gov.pl/api/v1/smog").openStream()));
    }
}
