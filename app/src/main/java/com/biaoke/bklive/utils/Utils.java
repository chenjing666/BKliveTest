package com.biaoke.bklive.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

import java.util.Date;
import java.util.regex.Pattern;

import static com.biaoke.bklive.consts.AppConsts.NETWORKTYPE_GPRS;
import static com.biaoke.bklive.consts.AppConsts.NETWORKTYPE_INVALID;
import static com.biaoke.bklive.consts.AppConsts.NETWORKTYPE_WIFI;


/**
 * Created by Holiday on 2017/1/23.
 * APP常用工具方法
 */

public class Utils {


    /**
     * 获取系统版本号
     */
    public static int getBuildVersion() {

        return android.os.Build.VERSION.SDK_INT;
    }

    /**
     * 获取APP版本名
     *
     * @param context
     * @return
     */
    public static String getVersionName(Context context) {
        return getPackageInfo(context).versionName;
    }

    /**
     * 获取APP版本号
     *
     * @param context
     * @return
     */
    public static int getVersionCode(Context context) {
        return getPackageInfo(context).versionCode;
    }

    private static PackageInfo getPackageInfo(Context context) {
        PackageInfo pi = null;
        try {
            PackageManager pm = context.getPackageManager();
            pi = pm.getPackageInfo(context.getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);

            return pi;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pi;
    }

    /**
     * 获取时间戳
     *
     * @return
     */
    public static String getTime() {
        String time = String.valueOf(new Date().getTime());
        return time;
    }

    /**
     * 获取IMEI
     */
    public static String getIMEI(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String imei = null;
        try {
            imei = tm.getDeviceId();
        } catch (Exception e) {
            imei = "";
        }
        if (StringUtils.isEmpty(imei)) {
            imei = "";
        }
        return imei;
    }

    /**
     * 判断联网方式
     *
     * @param context 返回值为0 没有网络
     *                返回值为1 使用手机网络
     *                返回值为2 使用wifi
     * @return
     */
    public static int getNetWorkType(Context context) {
        int mNetWorkType = 0;
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            String type = networkInfo.getTypeName();
            if (type.equalsIgnoreCase("WIFI")) {
                mNetWorkType = NETWORKTYPE_WIFI;
            } else if (type.equalsIgnoreCase("MOBILE")) {
                mNetWorkType = NETWORKTYPE_GPRS;
            }
        } else {
            mNetWorkType = NETWORKTYPE_INVALID;
        }
        return mNetWorkType;
    }

    /**
     * 获取MAC地址
     */
    public static String getMac(Context context) {
        WifiManager wifi = (WifiManager) context
                .getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        String mac = null;
        try {
            mac = info.getMacAddress();
        } catch (Exception e) {
            mac = "";
        }
        if (StringUtils.isEmpty(mac)) {
            mac = "";
        }
        return mac;
    }

    /**
     * 判断输入的是不是网址
     *
     * @param url
     * @return
     */
    public static boolean isUrl(String url) {
        Pattern pattern = Pattern
                .compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$");
        return pattern.matcher(url).matches();
    }
}
