package com.san.os.rcommendmovie.retrofit;

/**
 * Description: 数据解析异常
 */

public class CParserException extends CException {
    private String mJsonStr;

    public CParserException(String detailMsg, String jsonStr) {
        super(detailMsg);
        this.mJsonStr = jsonStr;
    }

    public String getJsonStr() {
        return mJsonStr;
    }
}
