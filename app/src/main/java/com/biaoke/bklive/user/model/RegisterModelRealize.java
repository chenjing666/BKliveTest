package com.biaoke.bklive.user.model;


import com.biaoke.bklive.consts.ErrorInfo;
import com.biaoke.bklive.consts.Message;
import com.biaoke.bklive.user.bean.User;
import com.biaoke.bklive.user.listener.UserListener;
import com.biaoke.bklive.user.listener.VerifyListener;
import com.biaoke.bklive.utils.StringUtils;
import com.biaoke.bklive.utils.VerifyUtils;

/**
 * Created by Rickey on 2017/2/24.
 */

public class RegisterModelRealize implements RegisterModel {

    private ErrorInfo errorInfo = new ErrorInfo();

    @Override
    public void onVerify(String mobile, VerifyListener listener) {
        if (listener != null) {
            if (StringUtils.isEmpty(mobile)) {
                errorInfo.setmMsg(Message.REGISTER_MOBILE_NULL);
                listener.onFailure(errorInfo);
            } else if (!VerifyUtils.verifyMobileNo(mobile)) {
                errorInfo.setmMsg(Message.REGISTER_MOBILE_ERROR);
                listener.onFailure(errorInfo);
            } else {
                // TODO: 2017/2/24 验证请求
                listener.onSuccess();
            }
        }
    }

    @Override
    public void onRegister(User user, UserListener listener) {
        if (listener != null) {
            String mobile, password, vCode;

        }
    }
}
