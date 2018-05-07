package com.san.os.rcommendmovie.rx;

/**
 */

public interface IHandleResult<T> {
    /**
     * Description: 返回成功的回调
     *
     * @param t 实体对象
     */
    void handleSuccess(T t);

    /**
     * Description: 返回异常回调
     *
     * @param throwable 异常信息
     *                  其他 IO异常
     */
    void handleError(Throwable throwable);

    /**
     * 回调完成
     */
    void handleComplete();
}
