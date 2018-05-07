package com.san.os.rcommendmovie.rx;


import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Description: Http请求基础观察者
 */

public abstract class BaseHttpObserver<T> implements Observer<T>, IHandleResult<T> {

    private DisponsablePresenter mPresenter;

    public BaseHttpObserver() {
    }

    public BaseHttpObserver(DisponsablePresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        if (mPresenter != null) {
            mPresenter.addDisponsable(d);
        }
    }

    @Override
    public void onNext(@NonNull T t) {
        handleSuccess(t);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        onHandleError(e);
    }

    @Override
    public void onComplete() {
        handleComplete();
    }

    /**
     * Description: API 返回失败的统一拦截处理
     *
     * @param throwable 异常信息
     */
    private void onHandleError(Throwable throwable) {
        handleError(throwable);
    }

    @Override
    public void handleComplete() {
    }
}
