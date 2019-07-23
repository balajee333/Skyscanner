package com.example.skyscanner.network.response.quote;

import com.google.gson.annotations.SerializedName;

public class Places {

    @SerializedName("PlaceId")
    public Long placeId;

    @SerializedName("IataCode")
    public String iataCode;

    @SerializedName("Name")
    public String name;

    @SerializedName("Type")
    public String type;

    @SerializedName("SkyscannerCode")
    public String skyscannerCode;

    @SerializedName("CityName")
    public String cityName;

    @SerializedName("CityId")
    public String cityId;

    @SerializedName("CountryName")
    public String countryName;



}
