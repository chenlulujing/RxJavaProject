package com.san.os.rcommendmovie.retrofit;


/**
 * Description: RrtrofitClient
 */

public class RrtrofitClient {
    /**
     * Description: 获取RetrofitSearvice
     *
     * @return RetrofitService
     */
    public static <T> T getRetrofit(final Class<T> service) {
        return RetrofitHelper.getBuilder().baseUrl("http://api.api").build().create(service);
    }
}
