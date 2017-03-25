package com.biaoke.bklive.user.realize;


import android.util.Log;

import com.biaoke.bklive.consts.ErrorInfo;
import com.biaoke.bklive.consts.Message;
import com.biaoke.bklive.http.MyCallBack;
import com.biaoke.bklive.http.UserRequestMethod;
import com.biaoke.bklive.user.bean.User;
import com.biaoke.bklive.user.listener.UserListener;
import com.biaoke.bklive.user.model.LoginModel;
import com.biaoke.bklive.utils.StringUtils;
import com.biaoke.bklive.utils.VerifyUtils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Holiday on 2017/2/21.
 * 登陆的方法
 */

public class LoginModelRealize implements LoginModel {
    private ErrorInfo errorInfo;

    @Override
    public void login(final User user, final UserListener listener) {
        if (errorInfo == null) {
            errorInfo = new ErrorInfo();
        }
        //参数非空判断
        if (StringUtils.isEmpty(user.getmMobile()) || StringUtils.isEmpty(user.getmPassWord())) {
            if (listener != null) {
                errorInfo.setmMsg(Message.LOGIN_PARAMETER_LOSE);
                listener.Failure(errorInfo);
            }
            return;
        }
        //登录名校验
//        if(!VerifyUtils.verifyMobileNo(user.getmMobile())){
//            if(listener!=null){
//                errorInfo.setmMsg(Message.LOGIN_USERNAME_ERROR);
//                listener.Failure(errorInfo);
//            }
//            return;
//        }
        //登陆密码校验
        if (!VerifyUtils.verifyPassword(user.getmPassWord())) {
            if (listener != null) {
                errorInfo.setmMsg(Message.LOGIN_PASSWORD_ERROR);
                listener.Failure(errorInfo);
            }
            return;
        }
        UserRequestMethod userRequestMethod = new UserRequestMethod();
        userRequestMethod.login(user, listener, new MyCallBack() {
            @Override
            public void OnSuccess(String json) {
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    User userInfo = new User();
                    userInfo.setmPassWord(user.getmPassWord());
                    userInfo.setmToken(jsonObject.getString("Result"));
                    Log.d("用户信息", jsonObject.getString("Result"));
                    if (listener != null) {
                        listener.Success(user);
                    }
//                    getUserInfo(userInfo,listener);
                } catch (JSONException e) {
                    if (listener != null) {
                        errorInfo.setmMsg(Message.HTTP_ERROR_JSON);
                        listener.Failure(errorInfo);
                    }
                }
            }

            @Override
            public void OnFailure(ErrorInfo info) {
                if (listener != null) {
                    listener.Failure(info);
                }
            }
        });
    }

//    private void getUserInfo(User userInfo, UserListener listener) {
//
//    }
}
