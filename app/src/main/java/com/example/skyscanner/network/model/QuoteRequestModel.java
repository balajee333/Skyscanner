package com.example.skyscanner.network.model;

public class QuoteRequestModel {

    
    private String origin;

    
    private String destination;

    
    private String onwardDate;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOnwardDate() {
        return onwardDate;
    }

    public void setOnwardDate(String onwardDate) {
        this.onwardDate = onwardDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    private String country;

    
    private String currency;

    
    private  String locale;
}
