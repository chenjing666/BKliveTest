package com.biaoke.bklive.consts;

/**
 * Created by Holiday on 2017/2/21.
 * 存放需要给用户提示的信息
 */
public class Message {

    //登陆相关
    public static final String LOGIN_PARAMETER_LOSE="登陆参数不完整！";

    public static final String LOGIN_USERNAME_ERROR="请输入正确的手机号！";

    public static final String LOGIN_PASSWORD_ERROR="用户密码长度在6~20位！";

    //网络相关
    public static final String HTTP_CONNECTION_TIMEOUT="网络连接超时,请检查网络连接！！！";

    public static final String HTTP_ERROR_JSON="返回数据解析JSON失败！！！";
    public static final String REGISTER_MOBILE_NULL = "请输入手机号";
    public static final String REGISTER_MOBILE_ERROR = "请输入正确的手机号";
    public static final String HTTP_ERROR_CREATE_JSON = "创建请求JSON失败！！！";
}
