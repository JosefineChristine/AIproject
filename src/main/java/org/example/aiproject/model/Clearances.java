package org.example.aiproject.model;

import java.util.List;

public class Clearances {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private List<Offer> offers;
    private List<Product> products;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Clearances(List<Offer> offers, List<Product> products) {
        this.offers = offers;
        this.products = products;
    }

    //***END***---------------------------------------------------------------------------------------------------------
}
