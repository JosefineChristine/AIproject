package org.example.aiproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Product {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private int id;
    private String description;
    private String ean;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Product(int id, String description, String ean) {
        this.id = id;
        this.description = description;
        this.ean = ean;
    }

    //***GETTER & SETTER***---------------------------------------------------------------------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    //***END***---------------------------------------------------------------------------------------------------------
}

