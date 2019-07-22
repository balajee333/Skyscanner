package com.example.skyscanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.skyscanner.databinding.ActivityQuotesBinding;
import com.example.skyscanner.network.model.QuoteRequestModel;
import com.example.skyscanner.utils.StringConstants;
import com.example.skyscanner.viewmodel.QuotesViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class QuotesActivity extends AppCompatActivity {

    private static final String TAG = "QuotesActivity";


    @Inject
    QuotesViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        ActivityQuotesBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_quotes);
        binding.setVm(vm);
        this.getLifecycle().addObserver(vm);

        Intent intent = getIntent();
        extractData(intent);

        RecyclerView quotesListView = binding.quoteslist;
        QuotesListAdapter adapter = vm.getAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        quotesListView.setLayoutManager(linearLayoutManager);
        quotesListView.setAdapter(adapter);
    }


    private void extractData(Intent intent) {
        QuoteRequestModel quoteRequestModel = new QuoteRequestModel();
        quoteRequestModel.setCountry(intent.getStringExtra(StringConstants.country));
        quoteRequestModel.setCurrency(intent.getStringExtra(StringConstants.currency));
        quoteRequestModel.setLocale(intent.getStringExtra(StringConstants.locale));
        quoteRequestModel.setOrigin(intent.getStringExtra(StringConstants.origin));
        quoteRequestModel.setDestination(intent.getStringExtra(StringConstants.destination));
        quoteRequestModel.setOnwardDate(intent.getStringExtra(StringConstants.onwardDate));
        vm.setQuoteRequestModel(quoteRequestModel);
    }
}
