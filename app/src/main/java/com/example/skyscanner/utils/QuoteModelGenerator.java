package com.example.skyscanner.utils;

import com.example.skyscanner.network.model.QuoteModel;
import com.example.skyscanner.network.response.quote.QuoteResponse;
import com.example.skyscanner.network.response.quote.Quotes;

import java.util.ArrayList;
import java.util.List;

public class QuoteModelGenerator {

    public static List<QuoteModel> getQuoteModels(QuoteResponse quoteResponse) {

        List<QuoteModel> quoteModels = new ArrayList<>();
        for(Quotes quote : quoteResponse.quotes) {
            QuoteModel quoteModel = new QuoteModel.Builder().setDirect(quote.direct).setMinPrice(quote.minPrice).setCurrency(quoteResponse.currencies.get(0).Code).create();
            quoteModels.add(quoteModel);
        }

        return quoteModels;
    }
}
