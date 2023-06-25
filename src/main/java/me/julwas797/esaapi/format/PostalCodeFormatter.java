package me.julwas797.esaapi.format;

import org.json.JSONObject;

/**
 * Postal code formatter, implemented using Singleton pattern
 *
 * @see #getInstance()
 */
public class PostalCodeFormatter {

    /**
     * Singleton instance
     */
    private static final PostalCodeFormatter INSTANCE = new PostalCodeFormatter();

    /**
     * This method is used to obtain the singleton instance of itself.
     *
     * @return A singleton instance of {@link PostalCodeFormatter}
     */
    public static PostalCodeFormatter getInstance() {
        return INSTANCE;
    }

    /**
     * Private constructor (per se Singleton implementation)
     */
    private PostalCodeFormatter() {
    }

    /**
     * Postal code formatting method.
     *
     * @param jsonObject {@link JSONObject} containing postal code.
     * @return Postal code or 0 if conversion throws exception.
     */
    public int format(JSONObject jsonObject) {
        int postalCode = 0;
        try {
            String postalCodeText = jsonObject.optString("post_code");
            if (postalCodeText != null) {
                postalCode = Integer.parseInt(postalCodeText.replace("-", ""));
            }
        } catch (Exception ignored) {
        }
        return postalCode;
    }
}
