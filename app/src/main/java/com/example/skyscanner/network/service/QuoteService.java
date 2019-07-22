package com.example.skyscanner.network.service;

import com.example.skyscanner.network.response.quote.QuoteResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface QuoteService {

    @GET("browsequotes/v1.0/{country}/{currency}/{locale}/{originplace}/{destinationplace}/{outboundpartialdate}")
    Observable<QuoteResponse> getQuotes(@Path(value = "country")String country,
                                        @Path(value = "currency")String currency,
                                        @Path(value = "locale")String locale,
                                        @Path(value = "originplace")String originplace,
                                        @Path(value = "destinationplace")String destinationplace,
                                        @Path(value = "outboundpartialdate")String outboundpartialdate);

}
