package com.san.os.rcommendmovie.retrofit;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Description: Http数据返回Gson解析类
 *
 * @param <T>
 */
final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;

    GsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        try {
            T responseBody = getResponseBody(response);
            return responseBody;
        } catch (Exception e) {
            //ErrResponse 将msg解析为异常消息文本
            throw new CParserException(e.getMessage(), response);
        } finally {
        }
    }

    /**
     * Description: 获取T类型数据对象
     * author: Lyongwang
     * date: 2017/5/17 下午4:29
     *
     * @param response
     * @return
     */
    private T getResponseBody(String response) {
        if (type instanceof Class) {
            Class clazz = (Class) type;
            if (clazz.equals(JSONObject.class)) {//如果返回类型 为JsonObject
                try {
                    return (T) new JSONObject(response);
                } catch (JSONException e) {

                }
            }
            if (clazz.equals(JSONArray.class)) {
                try {
                    return (T) new JSONArray(response);
                } catch (JSONException e) {

                }
            }
        }
        try {
            return gson.fromJson(response, type);
        } catch (JsonSyntaxException e) {
            try {
                return (T) response;
            } catch (Exception e1) {
                e1.printStackTrace();
                return null;
            }
        }
    }
}