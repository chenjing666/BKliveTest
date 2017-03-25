package com.biaoke.bklive.user.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.biaoke.bklive.R;
import com.biaoke.bklive.base.BaseActivity;
import com.biaoke.bklive.consts.AppConsts;
import com.biaoke.bklive.user.bean.User;
import com.biaoke.bklive.user.presenter.LoginPresenter;
import com.biaoke.bklive.user.view.LoginView;
import com.biaoke.bklive.utils.OnFriendlyClickListener;
import com.biaoke.bklive.utils.StringUtils;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.put_phone_num)
    EditText putPhoneNum;
    @BindView(R.id.put_password)
    EditText putPassword;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.tv_forgotpassword)
    TextView tvForgotpassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    LoginPresenter loginPresenter=new LoginPresenter(this);

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        login();
    }

    private void login() {
        btnLogin.setOnClickListener(new OnFriendlyClickListener() {
            @Override
            protected void OnFriendlyClick(View v) {
                loginPresenter.login();
                Log.d("LoginActivity","走了走了走了走了走了");
            }
        });
    }

    public Context getContext(){
        return this;
    }


    @Override
    public User getUserInfo() {
        User user = new User();
        user.setmMobile(putPhoneNum.getText().toString());
        user.setmPassWord(putPassword.getText().toString());
        return user;
    }

    @Override
    public void showToast(String mag) {
        if (StringUtils.isEmpty(mag)) {
            Logger.d("需要Toast的数据为空");
            return;
        }
        Toast.makeText(this, mag, Toast.LENGTH_SHORT).show();
    }



    @Override
    public void startRegistered() {

    }

    @Override
    public void startForgotPassword() {

    }

    @Override
    public void close() {
        finish();
    }

    @Override
    public void IntentTo() {
        startActivity(new Intent(LoginActivity.this,UserCenterActivity.class));
    }

    @OnClick({R.id.back, R.id.tv_register, R.id.tv_forgotpassword})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.tv_register:
                startRegistered();
                break;
            case R.id.tv_forgotpassword:
                startForgotPassword();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        finish();
        super.onDestroy();
    }

    @Override
    protected String getPowerBarColors() {
        return AppConsts.POWER_BAR_BACKGROUND;
    }
}
