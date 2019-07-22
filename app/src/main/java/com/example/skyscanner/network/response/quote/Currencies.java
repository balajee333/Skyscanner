package com.example.skyscanner.network.response.quote;

import com.google.gson.annotations.SerializedName;

public class Currencies {

    @SerializedName("Code")
    public String Code;

    @SerializedName("Symbol")
    public String Symbol;

    @SerializedName("ThousandsSeparator")
    public String ThousandsSeparator;

    @SerializedName("DecimalSeparator")
    public String DecimalSeparator;

    @SerializedName("SymbolOnLeft")
    public boolean SymbolOnLeft;

    @SerializedName("SpaceBetweenAmountAndSymbol")
    public boolean SpaceBetweenAmountAndSymbol;

    @SerializedName("RoundingCoefficient")
    public Integer RoundingCoefficient;

    @SerializedName("DecimalDigits")
    public Integer DecimalDigits;

}
