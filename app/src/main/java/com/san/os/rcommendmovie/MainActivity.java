package com.san.os.rcommendmovie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.san.os.rcommendmovie.datasource.MovieItemsDataSource;
import com.san.os.rcommendmovie.model.MoviesItemsModel;
import com.san.os.rcommendmovie.retrofit.NetResult;
import com.san.os.rcommendmovie.rx.BaseHttpObserver;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


}
