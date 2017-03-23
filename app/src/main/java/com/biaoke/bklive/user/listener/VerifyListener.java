package com.biaoke.bklive.user.listener;


import com.biaoke.bklive.consts.ErrorInfo;

/**
 * Created by Rickey on 2017/2/24.
 */

public interface VerifyListener {

    void onSuccess();

    void onFailure(ErrorInfo errorInfo);
}
