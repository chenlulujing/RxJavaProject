package com.san.os.rcommendmovie.service;

import com.san.os.rcommendmovie.constants.UrlParams;
import com.san.os.rcommendmovie.constants.Urls;
import com.san.os.rcommendmovie.model.MoviesItemsModel;
import com.san.os.rcommendmovie.retrofit.NetResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * @author luluc@yiche.com
 * @Description
 * @date 2017-11-13 23:01
 */

public interface MovieItemsService {

    @GET(Urls.GET_MOVIES_LIST)
    Observable<MoviesItemsModel> getMoviesItemList(@Query(UrlParams.k) String key);



    @GET(Urls.GET_GET1)
    Observable<NetResult<String>> get1();
    @GET(Urls.GET_GET2)
    Observable<NetResult<Integer>> get2();
}
