package com.example.skyscanner.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;

import com.example.skyscanner.network.model.QuoteModel;

public class QuotesListViewModel extends BaseObservable {


    private ObservableField<QuoteModel> quoteData = new ObservableField<>();

    public QuotesListViewModel() {

    }

    @Bindable
    public String getDirect() {
        if(quoteData.get().isDirect()) {
            return "Direct";
        } else {
            return "Not Direct";
        }
    }

    @Bindable
    public  String getMinPrice() {
        return Double.toString(quoteData.get().getMinPrice()) + " " + quoteData.get().getCurrency();
    }


    public void setQuoteModel(QuoteModel quoteModel) {
        quoteData.set(quoteModel);
    }
}
