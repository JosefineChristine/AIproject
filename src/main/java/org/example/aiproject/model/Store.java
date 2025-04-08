package org.example.aiproject.model;


public class Store {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String id;
    private String name;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Store(String id, String name) {
        this.id = id;
        this.name = name;
    }

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

