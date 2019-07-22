package com.example.skyscanner.dependencyinjection;

import com.example.skyscanner.MainActivity;
import com.example.skyscanner.QuotesActivity;
import com.example.skyscanner.network.response.quote.Quotes;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract MainActivity providesMainActivity();

    @ContributesAndroidInjector
    abstract QuotesActivity providesQuotesActivity();
}
