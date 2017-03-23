package com.biaoke.bklive.user.model;


import com.biaoke.bklive.user.bean.User;
import com.biaoke.bklive.user.listener.UserListener;
import com.biaoke.bklive.user.listener.VerifyListener;

/**
 * Created by Rickey on 2017/2/24.
 */

public interface RegisterModel {

    void onVerify(String mobile, VerifyListener listener);

    void onRegister(User user, UserListener listener);
}
