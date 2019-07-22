package com.example.skyscanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.skyscanner.databinding.ActivityMainBinding;
import com.example.skyscanner.network.response.quote.QuoteResponse;
import com.example.skyscanner.network.service.QuoteServiceProvider;
import com.example.skyscanner.utils.StringConstants;
import com.example.skyscanner.viewmodel.MainViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainViewModel vm;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setVm(vm);
    }

    public void findFlights(View view) {

        Intent intent = new Intent(this,QuotesActivity.class);
        startActivity(prepareData(intent));
    }

    private Intent prepareData(Intent intent) {
        intent.putExtra(StringConstants.country,vm.getCountry());
        intent.putExtra(StringConstants.currency,vm.getCurrency());
        intent.putExtra(StringConstants.locale,vm.getLocale());
        intent.putExtra(StringConstants.origin,vm.getOrigin());
        intent.putExtra(StringConstants.destination,vm.getDestination());
        intent.putExtra(StringConstants.onwardDate,vm.getOnwardDate());
        return intent;
    }
}
