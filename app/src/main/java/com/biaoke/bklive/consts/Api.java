package com.biaoke.bklive.consts;

/**
 * Created by Holiday on 2017/2/21.
 * 网络连接地址
 */
public class Api {
    private static final String ADDRESS = "http://172.16.1.144";

    public final static String LOGIN = ADDRESS + "/BK/Logging.php";//登陆接口

//    public final static String LOGOUT = ADDRESS + "/logout";//登出接口 get

    public final static String REGISTER = ADDRESS + "/BK/Register.php";//注册接口
}
