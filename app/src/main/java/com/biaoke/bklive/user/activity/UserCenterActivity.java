package com.biaoke.bklive.user.activity;

import android.os.Bundle;

import com.biaoke.bklive.R;
import com.biaoke.bklive.base.BaseActivity;
import com.biaoke.bklive.consts.AppConsts;

public class UserCenterActivity extends BaseActivity {


    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_user_center);
    }

    @Override
    protected String getPowerBarColors() {
        return AppConsts.POWER_BAR_BACKGROUND;
    }
}
