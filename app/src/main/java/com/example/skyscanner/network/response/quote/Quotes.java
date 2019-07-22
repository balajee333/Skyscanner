package com.example.skyscanner.network.response.quote;

import com.google.gson.annotations.SerializedName;

public class Quotes {

    @SerializedName("QuoteId")
    public String quoteId;

    @SerializedName("MinPrice")
    public Double minPrice;

    @SerializedName("Direct")
    public boolean direct;

    @SerializedName("OutboundLeg")
    public OutboundLeg outboundLeg;

    @SerializedName("InboundLeg")
    public InboundLeg inboundLeg;

    @SerializedName("QuoteDateTime")
    public String quoteDateTime;

}
