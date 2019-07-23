package com.example.skyscanner.network.response.quote;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuoteResponse {

    @SerializedName("Quotes")
    public List<Quotes> quotes;

    @SerializedName("Places")
    public List<Places> places;

    @SerializedName("Carriers")
    public List<Carriers> carriers;

    @SerializedName("Currencies")
    public List<Currencies> currencies;
}
