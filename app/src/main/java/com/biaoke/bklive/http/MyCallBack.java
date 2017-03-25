package com.biaoke.bklive.http;

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
    ErrorInfo errorInfo;

    @Override
    public void onError(Call call, Exception e, int id) {
        errorInfo = new ErrorInfo();
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
        if (errorInfo == null) {
            errorInfo = new ErrorInfo();
        }
        JSONObject object = new JSONObject(msg);
        Logger.d(object);
        String result = object.getString("Result");
//        String msssage = object.getString("Msg");
        if (result.equals("1")) {
            OnSuccess(object.toString());
        } else if (result.equals("0")) {
            errorInfo.setmMsg(object.getString("Msg"));
            OnFailure(errorInfo);
        }

    }

    public abstract void OnSuccess(String json);

    public abstract void OnFailure(ErrorInfo info);

}
