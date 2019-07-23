package com.example.skyscanner.network.service;

import com.example.skyscanner.network.response.quote.QuoteResponse;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class QuoteServiceProvider {


    @Inject
    QuoteService quoteService;

    @Inject
    QuoteServiceProvider() {

    }


    public Observable<QuoteResponse> getQuotes(String country,String currency,String locale,String originPlace,String destinationplace,String outboundpartialdate) {
        return quoteService.getQuotes(country,currency,locale,originPlace,destinationplace,outboundpartialdate).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

}
