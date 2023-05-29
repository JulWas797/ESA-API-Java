package me.julwas797.esaapi.format;

import lombok.Getter;
import org.json.JSONObject;

public class PostalCodeFormatter {

    @Getter
    private static final PostalCodeFormatter instance = new PostalCodeFormatter();
    private PostalCodeFormatter() {}
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
