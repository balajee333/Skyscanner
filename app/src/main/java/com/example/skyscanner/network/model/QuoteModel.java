package com.example.skyscanner.network.model;

public class QuoteModel {

    private String carrierName;

    private Double minPrice;

    private boolean direct;

    private String currency;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public QuoteModel(Builder builer) {
        this.carrierName = builer.getCarrierName();
        this.minPrice = builer.getMinPrice();
        this.direct = builer.isDirect();
        this.currency = builer.getCurrency();
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public boolean isDirect() {
        return direct;
    }

    public void setDirect(boolean direct) {
        this.direct = direct;
    }


    public static class Builder {

        private String carrierName;

        private Double minPrice;

        private boolean direct;

        private String currency;

        public String getCurrency() {
            return currency;
        }

        public Builder setCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public String getCarrierName() {
            return carrierName;
        }

        public Builder setCarrierName(String carrierName) {
            this.carrierName = carrierName;
            return this;
        }

        public Double getMinPrice() {
            return minPrice;
        }

        public Builder setMinPrice(Double minPrice) {
            this.minPrice = minPrice;
            return this;
        }

        public boolean isDirect() {
            return direct;
        }

        public Builder setDirect(boolean direct) {
            this.direct = direct;
            return this;
        }

        public Builder() {

        }

        public QuoteModel create() {
            return new QuoteModel(this);
        }


    }
}
