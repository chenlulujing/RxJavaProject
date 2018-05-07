package com.san.os.rcommendmovie.datasource;

import com.san.os.rcommendmovie.model.MoviesItemsModel;
import com.san.os.rcommendmovie.retrofit.NetResult;
import com.san.os.rcommendmovie.rx.RxUtil;
import com.san.os.rcommendmovie.service.MovieItemsService;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * @author luluc@yiche.com
 * @Description 电影列表的数据源（from net）
 * @date 2017-11-13 23:00
 */

public class MovieItemsDataSource extends BaseDataSource<MovieItemsService> {

    public MovieItemsDataSource() {
        super(MovieItemsService.class);
    }

    public Observable<MoviesItemsModel> getMoviesItemList(String k) {
        return mRetrofit.getMoviesItemList(k).compose(RxUtil.getDefaultTransformer());
    }

    public Observable<NetResult<String>> get1() {
        return mRetrofit.get1().compose(RxUtil.<NetResult<String>>getTransformer());
    }

    public Observable<NetResult<Integer>> get2() {
        return mRetrofit.get2().compose(RxUtil.<NetResult<Integer>>getTransformer());
    }


    public Observable<NetResult<String>> getCashString() {
        return Observable.create(new ObservableOnSubscribe<NetResult<String>>() {
            @Override
            public void subscribe(ObservableEmitter<NetResult<String>> e) throws Exception {
                NetResult result = new NetResult();
                result.data = "string";
                e.onNext(result);
            }
        });
    }


    public Observable<NetResult<Integer>> getCashInt() {
        return Observable.create(new ObservableOnSubscribe<NetResult<Integer>>() {
            @Override
            public void subscribe(ObservableEmitter<NetResult<Integer>> e) throws Exception {
//                e.onError(new NullPointerException());
                NetResult result = new NetResult();
                result.data = 3;
                e.onNext(result);
            }
        });
    }



}
