package com.biaoke.bklive.http;

import android.os.Handler;

import com.biaoke.bklive.consts.ErrorInfo;
import com.biaoke.bklive.consts.Message;
import com.orhanobut.logger.Logger;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;


/**
 * Created by Holiday on 2017/2/24
 * 网络返回参数处理工具类
 */

public abstract class MyCallBack extends StringCallback {
    Handler mHandler;
    ErrorInfo errorInfo;

    @Override
    public void onError(Call call, Exception e, int id) {
        if (errorInfo == null) {
            errorInfo = new ErrorInfo();
        }
        errorInfo.setmMsg(Message.HTTP_CONNECTION_TIMEOUT);
        OnFailure(errorInfo);
    }

    @Override
    public void onResponse(String response, int id) {
        try {
            setHandler(response);
        } catch (JSONException e) {
            if (errorInfo == null) {
                errorInfo = new ErrorInfo();
            }
            errorInfo.setmMsg(Message.HTTP_ERROR_JSON);
            OnFailure(errorInfo);
            Logger.e(Message.HTTP_ERROR_JSON, e);
        }
    }

    private void setHandler(String msg) throws JSONException {
        if (mHandler == null) {
            mHandler = new Handler();
        }
        if (errorInfo == null) {
            errorInfo = new ErrorInfo();
        }
        JSONObject object = new JSONObject(msg);
        mHandler.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    public abstract void OnSuccess(String json);

    public abstract void OnFailure(ErrorInfo info);
}
