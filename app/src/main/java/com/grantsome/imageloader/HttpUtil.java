package com.grantsome.imageloader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * 依赖了android-async-http框架，以发起网络请求，请求网络数据
 * Created by tom on 2017/2/12.
 */

public class HttpUtil {



    //判断网络是否可用
    public static boolean isNetWorkConntected(Context context){
        if(context!=null){
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo != null){
                return networkInfo.isAvailable();
            }
        }
        return false;
    }
}
