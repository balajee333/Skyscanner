package com.example.skyscanner.viewmodel;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.example.skyscanner.QuotesListAdapter;
import com.example.skyscanner.network.model.QuoteModel;
import com.example.skyscanner.network.model.QuoteRequestModel;
import com.example.skyscanner.network.response.quote.QuoteResponse;
import com.example.skyscanner.network.service.QuoteServiceProvider;
import com.example.skyscanner.utils.QuoteModelGenerator;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

public class QuotesViewModel implements LifecycleObserver {

    private static final String TAG = "QuotesViewModel";

    @Inject
    QuoteServiceProvider quoteServiceProvider;

    List<QuoteModel> quoteModels = new ArrayList<>();

    @Inject
    QuotesViewModel() {

    }

    QuotesListAdapter adapter;

    QuoteRequestModel quoteRequestModel;

    List<QuotesListViewModel> quotesListViewModels = new ArrayList<>();

    public QuotesListAdapter getAdapter() {
        adapter = new QuotesListAdapter(quotesListViewModels);
        return adapter;
    }

    public QuoteRequestModel getQuoteRequestModel() {
        return quoteRequestModel;
    }

    public void setQuoteRequestModel(QuoteRequestModel quoteRequestModel) {
        this.quoteRequestModel = quoteRequestModel;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        fetchQuotes();
    }

    private void fetchQuotes() {


        quoteServiceProvider.getQuotes(quoteRequestModel.getCountry(),
                quoteRequestModel.getCurrency(),
                quoteRequestModel.getLocale(),
                quoteRequestModel.getOrigin(),
                quoteRequestModel.getDestination(),
                quoteRequestModel.getOnwardDate()).subscribe(
                new Consumer<QuoteResponse>() {
                    @Override
                    public void accept(QuoteResponse quoteResponse) throws Exception {
                        quoteModels = QuoteModelGenerator.getQuoteModels(quoteResponse);
                        for (QuoteModel quoteModel : quoteModels) {
                            QuotesListViewModel quotesListViewModel = new QuotesListViewModel();
                            quotesListViewModel.setQuoteModel(quoteModel);
                            quotesListViewModels.add(quotesListViewModel);
                            adapter.notifyDataSetChanged();
                        }

                    }
                }
        );
    }
}
