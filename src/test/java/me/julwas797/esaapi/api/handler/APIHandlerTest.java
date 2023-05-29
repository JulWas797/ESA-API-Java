package me.julwas797.esaapi.api.handler;

import org.json.JSONArray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class APIHandlerTest {

    @Test
    void testGetJsonApiDataArray() {
        // Given
        String array = "[{\"foo\":\"bar\"},{\"baz\":\"bar\"}]";
        String wrapped = getWrapped(array);
        String wrappedInproper = getWrapped("\"foo\"");
        APIHandler apiHandler = getAPIHandler();
        // When
        JSONArray outputArray = apiHandler.getJsonApiDataArray(wrapped);
        JSONArray outputNull = apiHandler.getJsonApiDataArray(null);
        JSONArray outputOptNull = apiHandler.getJsonApiDataArray(wrappedInproper);
        // Then
        assertEquals(array, outputArray.toString(), "JSON should be parsed properly");
        assertNull(outputNull, "Empty list should return null");
        assertNull(outputOptNull, "Data without JSON array should return null");
    }

    @RepeatedTest(3)
    void testGetRawJsonData() {
        // Given
        List<String> dummyList = getRandomList();
        APIHandler apiHandler = spy(getAPIHandler());
        BufferedReader bufferedReader = new BufferedReader(new StringReader(String.join("\n", dummyList)));
        when(apiHandler.getReader()).thenReturn(bufferedReader);
        // When
        String output = apiHandler.getRawJsonData();
        // Then
        assertEquals(String.join("", dummyList), output, "List should be read properly.");
    }

package me.julwas797.esaapi.api.handler;

import org.json.JSONArray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class APIHandlerTest {

    @Test
    void testGetJsonApiDataArray() {
        // Given
        String array = "[{\"foo\":\"bar\"},{\"baz\":\"bar\"}]";
        String wrapped = getWrapped(array);
        String wrappedInproper = getWrapped("\"foo\"");
        APIHandler apiHandler = getAPIHandler();
        // When
        JSONArray outputArray = apiHandler.getJsonApiDataArray(wrapped);
        JSONArray outputNull = apiHandler.getJsonApiDataArray(null);
        JSONArray outputOptNull = apiHandler.getJsonApiDataArray(wrappedInproper);
        // Then
        assertEquals(array, outputArray.toString(), "JSON should be parsed properly");
        assertNull(outputNull, "Empty list should return null");
        assertNull(outputOptNull, "Data without JSON array should return null");
    }

    @RepeatedTest(3)
    void testGetRawJsonData() {
        // Given
        List<String> dummyList = getRandomList();
        APIHandler apiHandler = spy(getAPIHandler());
        BufferedReader bufferedReader = new BufferedReader(new StringReader(String.join("\n", dummyList)));
        when(apiHandler.getReader()).thenReturn(bufferedReader);
        // When
        String output = apiHandler.getRawJsonData();
        // Then
        assertEquals(String.join("", dummyList), output, "List should be read properly.");
    }

    private List<String> getRandomList() {
        Random random = new Random();
        String[] randomText = {"foo", "bar", "baz", "qux", "fred", "thud"};
        ArrayList<String> randomStringsList = new ArrayList<>();
        for (int i = 0; i < random.nextInt(10); i++) {
            randomStringsList.add(randomText[random.nextInt(6)]);
        }
        return randomStringsList;
    }

    private APIHandler getAPIHandler() {
        return APIHandler.getInstance();
    }

    private String getWrapped(String wrapper) {
        return String.format("{\"smog_data\":%s}", wrapper);
    }
}
    private APIHandler getAPIHandler() {
        return APIHandler.getInstance();
    }

    private String getWrapped(String wrapper) {
        return String.format("{\"smog_data\":%s}", wrapper);
    }
}
