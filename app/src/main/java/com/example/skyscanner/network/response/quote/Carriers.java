package com.example.skyscanner.network.response.quote;

import com.google.gson.annotations.SerializedName;

public class Carriers {

    @SerializedName("CarrierId")
    public Long carrierId;

    @SerializedName("Name")
    public String name;

}
