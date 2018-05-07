package com.san.os.rcommendmovie.retrofit;

/**
 * @author luluc@yiche.com
 * @Description
 * @date 2018-03-12 20:57
 */

public class NetResult<T> {

    public static final int SUCC_STATE = 1;
    public int status;
    public String message;
    public T data;

    public NetResult() {
    }

    public NetResult(int status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public String toString() {
        return "NR [status=" + status + ", message=" + message + ", data=" + data + "]";
    }

    public boolean isSuccess() {
        return status == 1;
    }

    public NetResult<T> setData(T data) {
        this.data = data;
        return this;
    }
}
