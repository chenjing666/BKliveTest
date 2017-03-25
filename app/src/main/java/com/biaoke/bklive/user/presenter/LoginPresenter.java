package com.biaoke.bklive.user.presenter;


import android.util.Log;

import com.biaoke.bklive.consts.AppConsts;
import com.biaoke.bklive.consts.ErrorInfo;
import com.biaoke.bklive.user.bean.User;
import com.biaoke.bklive.user.listener.UserListener;
import com.biaoke.bklive.user.realize.LoginModelRealize;
import com.biaoke.bklive.user.view.LoginView;

/**
 * Created by Holiday on 2017/2/21.
 * 登陆的方法
 */

public class LoginPresenter {
    private LoginModelRealize modelRealize;
    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.modelRealize = new LoginModelRealize();
        this.loginView = loginView;
    }

    public void login(){
        Log.d("LoginPresenter1","走了走了走了走了走了");
        modelRealize.login(loginView.getUserInfo(),new UserListener(){

            @Override
            public void Success(User user) {
                super.Success(user);
                AppConsts.mWhetherLogin=true;
                Log.d("LoginPresenter","走了走了走了走了走了");
                loginView.IntentTo();
                loginView.close();
            }

            @Override
            public void Failure(ErrorInfo info) {
                super.Failure(info);
                Log.d("LoginPresenter2","走了走了走了走了走了");
                loginView.showToast(info.getmMsg());
            }
        });
    }
}
