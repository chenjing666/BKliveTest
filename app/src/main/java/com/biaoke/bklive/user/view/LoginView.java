package com.biaoke.bklive.user.view;


import com.biaoke.bklive.user.bean.User;

/**
 * Created by Holiday on 2017/2/21.
 *
 */

public interface LoginView {

    User getUserInfo();

    void showToast(String mag);

    void startRegistered();

    void startForgotPassword();

    void close();
    void IntentTo();
}
