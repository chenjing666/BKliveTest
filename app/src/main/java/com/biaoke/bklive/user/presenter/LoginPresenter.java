package com.biaoke.bklive.user.presenter;


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
        modelRealize.login(loginView.getUserInfo(),new UserListener(){
            @Override
            public void Success(User user) {
                super.Success(user);
            }

            @Override
            public void Failure(ErrorInfo info) {
                super.Failure(info);
                loginView.showToast(info.getmMsg());
            }
        });
    }
}
