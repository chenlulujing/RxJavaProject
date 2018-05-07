package com.san.os.rcommendmovie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.san.os.rcommendmovie.datasource.MovieItemsDataSource;
import com.san.os.rcommendmovie.retrofit.NetResult;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {

        /**
         * zip
         */
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.zip(new MovieItemsDataSource().getNewsList().onErrorReturn(new Function<Throwable, NetResult<String>>() {
                            @Override
                            public NetResult<String> apply(Throwable throwable) throws Exception {
                                NetResult<String> get1Onerror = new NetResult<>();
                                get1Onerror.data = "error";
                                return null;
                            }
                        }),
                        new MovieItemsDataSource().getAD().onErrorReturn(new Function<Throwable, NetResult<Integer>>() {
                            @Override
                            public NetResult<Integer> apply(Throwable throwable) throws Exception {
                                return null;
                            }
                        }),
                        new BiFunction<NetResult<String>, NetResult<Integer>, Object>() {

                            @Override
                            public String  apply(NetResult<String> stringNetResult, NetResult<Integer> integerNetResult) throws Exception {

                                return stringNetResult.data+integerNetResult.data;
                            }
                        }
                ).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Object>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Object o) {
                                Log.i("lulu_rxzip","result=="+o.toString());
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.i("lulu_rxzip","onError");
                            }

                            @Override
                            public void onComplete() {

                            }
                        })
                ;
            }
        });
    }
}
