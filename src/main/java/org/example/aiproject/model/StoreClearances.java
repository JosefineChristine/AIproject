package org.example.aiproject.model;

import lombok.Data;

import java.util.List;

@Data
public class StoreClearances {
    private List<Clearance> clearances;
    private Store store;

}
