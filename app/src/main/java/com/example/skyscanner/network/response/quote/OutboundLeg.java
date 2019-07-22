package com.example.skyscanner.network.response.quote;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OutboundLeg {


    @SerializedName("CarrierIds")
    public List<Long> carrierIds;

    @SerializedName("OriginId")
    public Long originId;

    @SerializedName("DestinationId")
    public Long destinationId;

    @SerializedName("DepartureDate")
    public String departureDate;
}
