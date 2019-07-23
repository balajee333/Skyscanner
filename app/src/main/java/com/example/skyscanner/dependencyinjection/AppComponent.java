package com.example.skyscanner.dependencyinjection;

import com.example.skyscanner.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {NetworkModule.class,ActivityBuilderModule.class, AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<SkyscannerApplication> {
}
