package me.julwas797.esaapi.api.impl;

import me.julwas797.esaapi.api.DataSource;
import me.julwas797.esaapi.api.handler.APIHandler;
import me.julwas797.esaapi.common.APIEntry;
import me.julwas797.esaapi.common.SchoolEntry;
import me.julwas797.esaapi.common.SmogEntry;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Basic data source of air pollution data. <br>
 * It does not include any automatic refresh of data, so you should proceed with caution. <br>
 * For {@link DataSource} that contains refresh while initialization, please check {@link APIAutoDataSource}
 */
public class APIDataSource implements DataSource {
    /**
     * Returns a list of {@link APIEntry}
     *
     * @return List containing {@link APIEntry}
     */
    public List<APIEntry> getApiEntryList() {
        return apiEntryList;
    }

    /**
     * List containing {@link APIEntry}, obtained by {@link #getApiEntryList()} and fetched using {@link #refreshEntries()}
     */
    private List<APIEntry> apiEntryList = new ArrayList<>();

    /**
     * Method used to refresh entries in {@link #apiEntryList}
     */
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
