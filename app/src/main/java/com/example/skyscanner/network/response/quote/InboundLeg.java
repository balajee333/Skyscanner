package com.example.skyscanner.network.response.quote;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InboundLeg {

    @SerializedName("CarrierIds")
    public List<Long> carrierIds;

    @SerializedName("OriginId")
    public Long originId;

    @SerializedName("DestinationId")
    public Long destinationId;

    @SerializedName("DepartureDate")
    public String departureDate;
}
