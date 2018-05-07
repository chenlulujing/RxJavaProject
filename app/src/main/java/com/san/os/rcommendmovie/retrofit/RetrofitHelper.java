package com.san.os.rcommendmovie.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Description: Retrofit网络框架
 */

public class RetrofitHelper {
    private volatile static OkHttpClient.Builder clientBuilder;

    static {
        clientBuilder = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .pingInterval(10, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS);
    }

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .addConverterFactory(ResponseConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(clientBuilder.build());

    /**
     * Description: 获取RetrofitBuilder对象
     *
     * @return Retrofit.Builder
     */
    public static Retrofit.Builder getBuilder() {
        return builder;
    }

    public static OkHttpClient.Builder getOkHttpBuilder() {
        return clientBuilder;
    }

}
