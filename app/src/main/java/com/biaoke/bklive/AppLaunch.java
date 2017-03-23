package com.biaoke.bklive;

import android.app.Application;

import com.biaoke.bklive.utils.AppInit;


/**
 * Created by Holiday on 2017/2/22.
 * 初始化全部数据
 */

public class AppLaunch extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //参数初始化化。
        AppInit.init(getApplicationContext());
    }
}
