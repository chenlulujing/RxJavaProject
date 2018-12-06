package com.san.os.rcommendmovie.retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * @author chenlulu@qiyi.com
 * @Description
 * @date 2018-09-10 14:33
 */

public class MyCallAdapter extends CallAdapter.Factory {


    public static MyCallAdapter create(){
       return new MyCallAdapter();
    }

    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        Class<?> rawType  =   getRawType(returnType);

        return null;
    }
}
