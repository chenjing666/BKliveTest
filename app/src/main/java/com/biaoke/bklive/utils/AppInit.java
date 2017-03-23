package com.biaoke.bklive.utils;

import android.content.Context;

import com.biaoke.bklive.consts.AppConsts;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.Settings;


/**
 * Created by Holiday on 2017/2/21.
 * APP的初始化
 */

public class AppInit {

    /**
     * 初始化方法
     * @param context　
     */
    public static  void init(Context context){
        AppConsts.mScreenWidth=ScreenUtils.getScreenWidth(context);

        AppConsts.mScreenHeight=ScreenUtils.getScreenHeight(context);

        AppConsts.mBuildVersion=Utils.getBuildVersion();

        AppConsts.mVersionCode=Utils.getVersionCode(context);

        AppConsts.mVersionName=Utils.getVersionName(context);

        AppConsts.mImei=Utils.getIMEI(context);

        AppConsts.mMac=Utils.getMac(context);

        new SPUtils(context,"CF_SP_INFO");//初始化SP工具类

        Settings settings= Logger.init("CFlog");

        settings.methodCount(3); // 配置Log中调用堆栈的函数行数

        //settings.hideThreadInfo(); // 隐藏Log中的线程信息

        settings.methodOffset(0); // 设置调用堆栈的函数偏移值，0的话则从打印该Log的函数开始输出堆栈信息

        settings.logLevel(LogLevel.FULL); // 设置Log的是否输出，LogLevel.NONE即无Log输出

    }
}
