package com.san.os.rcommendmovie.rx;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;


/**
 * Description: RxJava线程工具类
 * author: Lyongwang
 * date: 2017/5/17 下午4:32
 */

public class RxUtil {
    /**
     * Description: 获取默认ObservableTransformer
     * author: Lyongwang
     * date: 2017/5/17 下午4:32
     * @return subscribeOn ioThread  observeOn mainThread
     */
    public static <T> ObservableTransformer<T, T> getTransformer(){
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    @Deprecated
    /**
     * @see use #getTransformer()
     */
    public static ObservableTransformer getDefaultTransformer(){
        return new ObservableTransformer() {
            @Override
            public ObservableSource apply(@NonNull Observable upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
