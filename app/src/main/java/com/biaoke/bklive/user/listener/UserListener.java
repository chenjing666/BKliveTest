package com.biaoke.bklive.user.listener;


import com.biaoke.bklive.consts.ErrorInfo;
import com.biaoke.bklive.user.bean.User;

/**
 * Created by Holiday on 2017/2/21.
 *
 */

public class UserListener {
    public  void Success(User user){};
    public  void Failure(ErrorInfo info){};
}
