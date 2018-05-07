package com.san.os.rcommendmovie.rx;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by lyongwang on 2017/11/2.
 */

public class DisponsablePresenter {
    private CompositeDisposable mDisposables = new CompositeDisposable();

    public void addDisponsable(Disposable... disposables){
        mDisposables.addAll(disposables);
    }

    public void clearDisponsables(){
        mDisposables.clear();
    }
}
