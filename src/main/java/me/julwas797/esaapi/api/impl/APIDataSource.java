package me.julwas797.esaapi.api.impl;

import lombok.Getter;
import me.julwas797.esaapi.api.AbstractDataSource;
import me.julwas797.esaapi.api.handler.APIHandler;
import me.julwas797.esaapi.common.APIEntry;
import me.julwas797.esaapi.common.SchoolEntry;
import me.julwas797.esaapi.common.SmogEntry;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class APIDataSource implements AbstractDataSource {

    @Getter
    private List<APIEntry> apiEntryList = new ArrayList<>();

    public void refreshEntries() {
        JSONArray apiJsonEntries = APIHandler.getInstance().getJsonApiDataArray();
        if (!apiJsonEntries.isEmpty()) {
            // TODO: Rewrite to Streams API when https://github.com/stleary/JSON-java/issues/737 is fixed.
            // This is temporary solution
            List<APIEntry> temporaryList = new ArrayList<>();
            apiJsonEntries.forEach(entry -> {
                JSONObject newEntry = new JSONObject(entry.toString());
                SchoolEntry schoolEntry = new SchoolEntry(newEntry.getJSONObject("school"));
                SmogEntry smogEntry = new SmogEntry(newEntry.getJSONObject("data"));
                temporaryList.add(new APIEntry(schoolEntry, smogEntry));
            });
            apiEntryList = temporaryList;
        }
    }
}
