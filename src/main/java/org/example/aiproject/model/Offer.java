package org.example.aiproject.model;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

public class Offer {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private int id;
    private String currency;
    private String ean;
    private ZonedDateTime endTime;
    private ZonedDateTime lastUpdate;
    private int newPrice;
    private int originalPrice;
    private int percentDiscount;
    private ZonedDateTime startTime;
    private double stock;
    private String stockUnit;
    private double discount;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Offer(int id, String currency, String ean, ZonedDateTime endTime, ZonedDateTime lastUpdate, int newPrice, int originalPrice, int percentDiscount, ZonedDateTime startTime, double stock, String stockUnit, double discount) {
        this.id = id;
        this.currency = currency;
        this.ean = ean;
        this.endTime = endTime;
        this.lastUpdate = lastUpdate;
        this.newPrice = newPrice;
        this.originalPrice = originalPrice;
        this.percentDiscount = percentDiscount;
        this.startTime = startTime;
        this.stock = stock;
        this.stockUnit = stockUnit;
        this.discount = discount;
    }

    //***GETTER & SETTER***---------------------------------------------------------------------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public ZonedDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(ZonedDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(int newPrice) {
        this.newPrice = newPrice;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(int percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public String getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(String stockUnit) {
        this.stockUnit = stockUnit;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    //***END***---------------------------------------------------------------------------------------------------------
}

