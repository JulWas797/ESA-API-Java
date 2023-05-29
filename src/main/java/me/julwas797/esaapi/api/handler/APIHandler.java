package me.julwas797.esaapi.api.handler;

import lombok.Getter;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class APIHandler {

     @Getter
     private static final APIHandler instance = new APIHandler();
     private APIHandler() {}

     public JSONArray getJsonApiDataArray(String source) {
          if (source == null) {
               return null;
          }
          else {
               JSONObject formattedApiData = new JSONObject(source);
               return formattedApiData.optJSONArray("smog_data");
          }
     }

     public JSONArray getJsonApiDataArray() {
          return getJsonApiDataArray(getRawJsonData());
     }

     @SneakyThrows
     public String getRawJsonData() {
          String lines;
          try (BufferedReader apiReader = getReader()) {
               lines = apiReader.lines().collect(Collectors.joining());
          }
          return lines;
     }

     @SneakyThrows
     protected BufferedReader getReader() {
          return new BufferedReader(new InputStreamReader(new URL("https://public-esa.ose.gov.pl/api/v1/smog").openStream()));
     }
}
