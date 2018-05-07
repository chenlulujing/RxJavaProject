package com.san.os.rcommendmovie.retrofit;

/**
 * Description: 基础异常类
 */

public class CException extends RuntimeException {

    public CException() {
    }

    public CException(String detailMessage) {
        super(detailMessage);
    }

    public CException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public CException(Throwable throwable) {
        super(throwable);
    }
}
