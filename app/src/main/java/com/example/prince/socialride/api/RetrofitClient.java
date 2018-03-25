package com.example.prince.socialride.api;

/**
 * Created by prince on 11/19/2017.
 */

import com.example.prince.tinderlike.App;

import java.io.IOException;

import dimitrovskif.smartcache.BasicCaching;
import dimitrovskif.smartcache.SmartCallFactory;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {
        SmartCallFactory smartFactory = new SmartCallFactory(BasicCaching.fromCtx(App.getContext()));
        if (retrofit==null) {
            OkHttpClient client = new OkHttpClient
                    .Builder()
                    .cache(new Cache(App.getApplication().getCacheDir(), 10 * 1024 * 1024))
                    .addInterceptor(new Interceptor() {
                        @Override public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request();
                            if (App.isNetworkAvailable()) {
                                request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build();
                            } else {
                                request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build();
                            }
                            return chain.proceed(request);
                        }
                    })
                    .build();


            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(smartFactory)
                    .client(client)
                    .build();
        }
        return retrofit;
    }
}