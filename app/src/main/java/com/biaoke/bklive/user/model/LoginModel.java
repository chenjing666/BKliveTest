package com.biaoke.bklive.user.model;


import com.biaoke.bklive.user.bean.User;
import com.biaoke.bklive.user.listener.UserListener;

/**
 * Created by Holiday on 2017/2/21.
 */

public interface LoginModel {
    /**
     * 登陆的方法
     * @param user
     * @param listener
     */
    void login(User user, UserListener listener);
}
