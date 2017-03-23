package com.biaoke.bklive.user.realize;


import com.biaoke.bklive.consts.ErrorInfo;
import com.biaoke.bklive.consts.Message;
import com.biaoke.bklive.user.bean.User;
import com.biaoke.bklive.user.listener.UserListener;
import com.biaoke.bklive.user.model.LoginModel;
import com.biaoke.bklive.utils.StringUtils;
import com.biaoke.bklive.utils.VerifyUtils;

/**
 * Created by Holiday on 2017/2/21.
 * 登陆的方法
 */

public class LoginModelRealize implements LoginModel {
    private ErrorInfo errorInfo;
    @Override
    public void login(User user, UserListener listener) {
        if(errorInfo==null){
            errorInfo=new ErrorInfo();
        }
        //参数非空判断
        if(StringUtils.isEmpty(user.getmMobile())|| StringUtils.isEmpty(user.getmPassWord())){
           if(listener!=null){
               errorInfo.setmMsg(Message.LOGIN_PARAMETER_LOSE);
               listener.Failure(errorInfo);
           }
            return;
        }
        //登录名校验
        if(!VerifyUtils.verifyMobileNo(user.getmMobile())){
            if(listener!=null){
                errorInfo.setmMsg(Message.LOGIN_USERNAME_ERROR);
                listener.Failure(errorInfo);
            }
            return;
        }
        //登陆密码校验
        if(!VerifyUtils.verifyPassword(user.getmPassWord())){
            if(listener!=null){
                errorInfo.setmMsg(Message.LOGIN_PASSWORD_ERROR);
                listener.Failure(errorInfo);
            }
            return;
        }
    }
}
