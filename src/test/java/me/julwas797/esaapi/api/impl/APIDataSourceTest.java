package me.julwas797.esaapi.api.impl;

import me.julwas797.esaapi.api.handler.APIHandler;
import me.julwas797.esaapi.common.APIEntry;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class APIDataSourceTest {

    @Test
    void refreshEntriesAndGet() {
        // Given
        APIDataSource apiDataSource = new APIDataSource();
        // When
        apiDataSource.refreshEntries();
        List<APIEntry> apiEntryList = apiDataSource.getApiEntryList();
        // Then
        assertNotNull(apiEntryList, "API Entry list shouldn't be null");
        assertFalse(apiEntryList.isEmpty(), "API Entry list shouldn't be empty");
    }
}