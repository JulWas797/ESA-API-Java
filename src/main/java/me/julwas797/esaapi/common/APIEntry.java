package me.julwas797.esaapi.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class APIEntry {
    private final SchoolEntry schoolEntry;
    private final SmogEntry smogEntry;
}
