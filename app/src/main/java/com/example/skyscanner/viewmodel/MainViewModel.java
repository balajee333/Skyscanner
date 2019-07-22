package com.example.skyscanner.viewmodel;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import javax.inject.Inject;

public class MainViewModel extends BaseObservable {

    private static final String TAG = "MainViewModel";

    @Inject
    MainViewModel() {

    }

    @Bindable
    private String origin;

    @Bindable
    private String destination;

    @Bindable
    private String onwardDate;

    @Bindable
    private String country;

    @Bindable
    private String currency;

    @Bindable
    private  String locale;

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

}
