package com.san.os.rcommendmovie.observer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
//        ConnectivityManager connectivityManager = (ConnectivityManager) context
//                .getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetInfo = connectivityManager
//                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//        boolean isConnected = activeNetInfo != null
//                && activeNetInfo.isConnected();
//
//        int networkStatus;
//        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
//        if (info != null && info.isAvailable()) {
//            String name = info.getTypeName();
//            if (name.equals("WIFI")) {
//                networkStatus = 2;
//            } else {
//                networkStatus = 1;
//            }
//
//        } else {
//            networkStatus = 0;
//        }
//        Log.i("lulu_wangluo","NetworkChangeReceiver networkStatus=="+networkStatus);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            System.out.println("API level 大于23");
            //获得ConnectivityManager对象
            ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            //获取所有网络连接的信息
            Network[] networks = connMgr.getAllNetworks();
            //用于存放网络连接信息
            StringBuilder sb = new StringBuilder();
            //通过循环将网络信息逐个取出来
            for (int i=0; i < networks.length; i++){
                //获取ConnectivityManager对象对应的NetworkInfo对象
                NetworkInfo networkInfo = connMgr.getNetworkInfo(networks[i]);
                sb.append(networkInfo.getTypeName() + " connect is " + networkInfo.isConnected());
            }
            Toast.makeText(context, sb.toString(),Toast.LENGTH_SHORT).show();
            Log.i("lulu_wangluo","NetworkChangeReceiver networkStatus=="+sb.toString());
        }


    }
}