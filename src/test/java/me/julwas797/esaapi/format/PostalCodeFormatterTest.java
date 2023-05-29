package me.julwas797.esaapi.format;

import org.json.JSONObject;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PostalCodeFormatterTest {

    @RepeatedTest(5)
    void testFormat() {
        // Given
        JSONObject badPostalCode = new JSONObject();
        Random r = new Random();
        int randomNum = 10000 + r.nextInt(90000);
        JSONObject postalCode = getWrappedPostalCode(String.format("\"%s\"", generatePostalCode(randomNum)));
        PostalCodeFormatter postalCodeFormatter = PostalCodeFormatter.getInstance();
        // When
        int badOutput = postalCodeFormatter.format(badPostalCode);
        int goodOutput = postalCodeFormatter.format(postalCode);
        // Then
        assertEquals(0, badOutput, "Bad postal code should be equal to zero");
        assertEquals(randomNum, goodOutput, "Postal code should be equal to init val");
    }

    private String generatePostalCode(int code) {
        String postalCode = String.valueOf(code);
        return String.format("%s-%s", postalCode.substring(0, 2), postalCode.substring(2));
    }

    private JSONObject getWrappedPostalCode(String postalCode) {
        return new JSONObject(String.format("{\"post_code\":%s}", postalCode));
    }
}