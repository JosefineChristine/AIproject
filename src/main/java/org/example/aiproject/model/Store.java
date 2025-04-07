package org.example.aiproject.model;

import jakarta.persistence.Id;

public class Store {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    @Id
    private String id;
    private String name;

    //***GETTER& SETTER***----------------------------------------------------------------------------------------------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

