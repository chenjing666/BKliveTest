package com.biaoke.bklive.utils;

import android.view.View;

import java.util.Calendar;

/**
 * Created by Holiday on 2017/2/22.
 * 禁止用户重复点击的响应监听
 */

public abstract class OnFriendlyClickListener implements View.OnClickListener {
    final int MIN_CLICK_DELAY_TIME = 2000;
    private long lastClickTime = 0;
    @Override
    public void onClick(View v) {
        long   currentTime = Calendar.getInstance().getTimeInMillis();
        if(currentTime-lastClickTime>MIN_CLICK_DELAY_TIME){
            lastClickTime  =  currentTime;
            OnFriendlyClick(v);
            return ;
        }
    }

    protected abstract void OnFriendlyClick(View v);
}
