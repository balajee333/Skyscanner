package com.example.skyscanner.network;


import androidx.core.view.ViewCompat;

import com.example.skyscanner.network.service.QuoteService;
import com.example.skyscanner.utils.StringConstants;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {


    @Singleton
    @Provides
    Retrofit providesRetrofit(OkHttpClient client, GsonConverterFactory gsonConverterFactory, RxJava2CallAdapterFactory rxJava2CallAdapterFactory) {

        Retrofit retrofitClient = new Retrofit.Builder().
                client(client).
                addConverterFactory(gsonConverterFactory).
                addCallAdapterFactory(rxJava2CallAdapterFactory).
                baseUrl(StringConstants.BASE_URL).build();

        return retrofitClient;
    }

    @Singleton
    @Provides
    OkHttpClient providesOkHttpClient(Interceptor headerInterceptor, HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder().addInterceptor(headerInterceptor).addInterceptor(httpLoggingInterceptor).build();
    }

    @Singleton
    @Provides
    Interceptor provideHeaderInterceptor() {
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Headers headers = request.headers().newBuilder().
                        add(StringConstants.X_RAPID_API_KEY,StringConstants.X_RAPID_API_KEY_VALUE).build();
                request = request.newBuilder().headers(headers).build();
                return chain.proceed(request);
            }
        };
        return headerInterceptor;

    }

    @Singleton
    @Provides
    HttpLoggingInterceptor providesHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Singleton
    @Provides
    GsonConverterFactory providesGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    RxJava2CallAdapterFactory providesRxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    QuoteService providesQuoteService(Retrofit retrofit) {
        return retrofit.create(QuoteService.class);
    }

}
