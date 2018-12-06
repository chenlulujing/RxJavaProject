package com.san.os.rcommendmovie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.san.os.rcommendmovie.datasource.MovieItemsDataSource;
import com.san.os.rcommendmovie.retrofit.NetResult;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    static {
        RxJavaPlugins.setErrorHandler(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e("lulu_error", "UncaughtException: accept");
            }
        });
    }

    Disposable mDisposable;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        Log.i("lulu_statebar",getStatusBarHeight()+"");
        RxJavaPlugins.setErrorHandler(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });

        new MovieItemsDataSource().getAD().subscribe(new Observer<NetResult<Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(NetResult<Integer> integerNetResult) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }



    private void initview() {

        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
                    @Override
                    public String apply(Integer integer, String s) throws Exception {
                        return integer + s;
                    }
                }).subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("lulu_rxzip", "onSubscribe");
                    }

                    @Override
                    public void onNext(String value) {
                        Log.d("lulu_rxzip", "onNext: " + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("lulu_rxzip", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("lulu_rxzip", "onComplete");
                    }
                });
            }
        });



        /**
         * zip
         */
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.zip(new MovieItemsDataSource().getNewsList().onErrorReturn(new Function<Throwable, NetResult<String>>() {
                            @Override
                            public NetResult<String> apply(Throwable throwable) throws Exception {
                                NetResult<String> listError = new NetResult<>();
                                listError.data = "error";
                                return listError;
                            }
                        }),
                        new MovieItemsDataSource().getAD().onErrorReturn(new Function<Throwable, NetResult<Integer>>() {
                            @Override
                            public NetResult<Integer> apply(Throwable throwable) throws Exception {
                                return new NetResult<Integer>();
                            }
                        }),
                        new BiFunction<NetResult<String>, NetResult<Integer>, Object>() {

                            @Override
                            public String apply(NetResult<String> stringNetResult, NetResult<Integer> integerNetResult) throws Exception {

                                return stringNetResult.data + integerNetResult.data;
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
                                Log.i("lulu_rxzip", "result==" + o.toString());
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.i("lulu_rxzip", "onError");
                            }

                            @Override
                            public void onComplete() {

                            }
                        })
                ;
            }
        });

        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDisposable.dispose();

            }
        });
    }



    Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
        @Override
        public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
            emitter.onNext(1);
            Thread.sleep(1000);

            emitter.onNext(2);
            Thread.sleep(1000);

            emitter.onNext(3);
            Thread.sleep(1000);

            emitter.onNext(4);
            Thread.sleep(1000);

            emitter.onComplete();
        }
    }).subscribeOn(Schedulers.io());

    Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
        @Override
        public void subscribe(ObservableEmitter<String> emitter) throws Exception {
            emitter.onNext("A");
            Thread.sleep(1000);

            emitter.onNext("B");
            Thread.sleep(1000);

            emitter.onNext("C");
            Thread.sleep(1000);

            emitter.onComplete();
        }
    }).subscribeOn(Schedulers.io());


    public  int getStatusBarHeight() {
        int statusBarHeight = 0;
        try {
            //获取status_bar_height资源的ID
            int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                //根据资源ID获取响应的尺寸值
                statusBarHeight = getResources().getDimensionPixelSize(resourceId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight;
    }

}
