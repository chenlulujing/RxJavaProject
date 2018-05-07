package com.san.os.rcommendmovie.datasource;

import com.san.os.rcommendmovie.retrofit.RrtrofitClient;

/**
 * @author luluc@yiche.com
 * @Description
 * @date 2017-11-13 22:58
 */

public abstract class BaseDataSource<T> {

    protected final T mRetrofit;

    public BaseDataSource(Class<T> service) {
        mRetrofit = RrtrofitClient.getRetrofit(service);
    }
}
