package com.biaoke.bklive.http;


import com.biaoke.bklive.consts.Api;
import com.biaoke.bklive.consts.ErrorInfo;
import com.biaoke.bklive.consts.Message;
import com.biaoke.bklive.user.bean.User;
import com.biaoke.bklive.user.listener.UserListener;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Holiday on 2017/3/6.
 * 用户接口方法
 */

public class UserRequestMethod {

    public UserRequestMethod() {

    }

    /**
     * 用户登陆方法
     *
     * @param user
     * @param listener
     * @param callBack
     */
    public void login(User user, UserListener listener, MyCallBack callBack) {
        JSONObject paramsObject = new JSONObject();
        try {
            paramsObject.put("Name", user.getmMobile());//手机号码
            paramsObject.put("Password", user.getmPassWord());//密码
            paramsObject.put("PwdModel","1");
            paramsObject.put("Sys","android");
            paramsObject.put("Version","BK_V1_20130313");
            paramsObject.put("Imei","0");
            OkHttp.postJson(Api.LOGIN, paramsObject.toString(), callBack);
        } catch (JSONException e) {
            e.printStackTrace();
            if (listener != null) {
                ErrorInfo errorInfo = new ErrorInfo();
                errorInfo.setmMsg(Message.HTTP_ERROR_CREATE_JSON);
                listener.Failure(errorInfo);
            }

        }
    }

    /**
     * 获取验证码
     * @param type  短信模板编码，用户注册member_register，手机号变更mobile_change
     * @param mobile
     * @param callBack
     */
//    public void getSms(String type,String mobile, MyCallBack callBack) {
//        StringBuffer sb=new StringBuffer();
//        sb.append(Api.GETSMS+"?");
//        sb.append("code=").append(type);
//        sb.append("&mobile=").append(mobile);
//        OkHttp.get(sb.toString(),callBack);
//    }

    /**
     * 获取七云牛上传凭证
     * @param code
     * @param token
     * @param callBack
     */
//    public void getQiniuToken(String code,String token, MyCallBack callBack) {
//        StringBuffer sb=new StringBuffer();
//        sb.append(Api.GETUPLOADTOKEN+"?");
//        sb.append("code=").append(code);
//        sb.append("&token=").append(token);
//        OkHttp.get(sb.toString(),callBack);
//    }

    /**
     * 注册方法
     *
     * @param user
     * @param listener
     * @param callBack
     */
//    public void register(User user, UserListener listener, MyCallBack callBack) {
//        JSONObject paramsObject = new JSONObject();
//        try {
//            paramsObject.put("mobile", user.getmMobile());//手机号码
//            paramsObject.put("password", user.getmPassWord());//密码
//            paramsObject.put("captcha_sms", user.getmCode());//短信验证码
//            paramsObject.put("sn", user.getmUmengChannel());//短信验证码
//            paramsObject.put("channel_id", user.getmCompanyChannel());//短信验证码
//            //paramsObject.put("captcha_sms", "万能的验证码");//短信验证码
//            OkHttp.postJson(Api.REGISTER, paramsObject.toString(), callBack);
//        } catch (JSONException e) {
//            e.printStackTrace();
//            if (listener != null) {
//                ErrorInfo errorInfo = new ErrorInfo();
//                errorInfo.setmMsg(Message.HTTP_ERROR_CREATE_JSON);
//                listener.Failure(errorInfo);
//            }
//        }
//    }

    /**
     * 基本资料变更
     *
     * @param user
     * @param listener
     * @param callBack
     */
//    public void profile(User user, FailureListener listener, MyCallBack callBack) {
//        JSONObject paramsObject = new JSONObject();
//        try {
//            paramsObject.put("id_card_back_url", user.getmCardBack());//身份证背面照url
//            paramsObject.put("id_card_front_url", user.getmCardFront());//身份证正面照url
//            paramsObject.put("id_no", user.getmCardNo());//身份证号码
//            paramsObject.put("real_name", user.getmRealName());//真实姓名
//             paramsObject.put("captcha_sms", user.getmCode());//短信验证码
//           // paramsObject.put("captcha_sms", "万能的验证码");//短信验证码
//            paramsObject.put("token", SPUserUtils.getString(AppConsts.SP_TOKEN,""));//token
//            OkHttp.postJson(Api.PROFILE, paramsObject.toString(), callBack);
//        } catch (JSONException e) {
//            e.printStackTrace();
//            if (listener != null) {
//                ErrorInfo errorInfo = new ErrorInfo();
//                errorInfo.setmMsg(Message.HTTP_ERROR_CREATE_JSON);
//                listener.onFailure(errorInfo);
//            }
//        }
//    }

    /**
     * 更改头像
     *
     * @param user
     * @param listener
     * @param callBack
     */
//    public void head(User user, UserListener listener, MyCallBack callBack) {
//        JSONObject paramsObject = new JSONObject();
//        try {
//            paramsObject.put("head_url", user.getmHeadImg());//头像路径
//            paramsObject.put("token", SPUserUtils.getString(AppConsts.SP_TOKEN,""));//token
//            OkHttp.postJson(Api.HEAD, paramsObject.toString(), callBack);
//        } catch (JSONException e) {
//            e.printStackTrace();
//            if (listener != null) {
//                ErrorInfo errorInfo = new ErrorInfo();
//                errorInfo.setmMsg(Message.HTTP_ERROR_CREATE_JSON);
//                listener.Failure(errorInfo);
//            }
//        }
//    }

    /**
     * 更改手机号
     *
     * @param user
     * @param listener
     * @param callBack
     */
//    public void changeMobile(User user, UserListener listener, MyCallBack callBack) {
//        JSONObject paramsObject = new JSONObject();
//        try {
//            paramsObject.put("captcha_sms", user.getmHeadImg());//验证码
//            paramsObject.put("mobile", user.getmNewMobile());//新手机
//            paramsObject.put("token", user.getmToken());//token
//            OkHttp.postJson(Api.CHANGEMOBILE, paramsObject.toString(), callBack);
//        } catch (JSONException e) {
//            e.printStackTrace();
//            if (listener != null) {
//                ErrorInfo errorInfo = new ErrorInfo();
//                errorInfo.setmMsg(Message.HTTP_ERROR_CREATE_JSON);
//                listener.Failure(errorInfo);
//            }
//        }
//    }

    /**
     * 忘记密码
     * @param user
     * @param listener
     * @param callBack
     */
//    public void forgetPass(User user, FailureListener listener, MyCallBack callBack) {
//        JSONObject paramsObject = new JSONObject();
//        try {
//             paramsObject.put("captcha_sms", user.getmCode());//短信验证码
//            //paramsObject.put("captcha_sms", "万能的验证码");//短信验证码
//            paramsObject.put("mobile", user.getmMobile());//新手机
//            paramsObject.put("password", user.getmPassWord());
//            OkHttp.postJson(Api.RESETPASSWORD, paramsObject.toString(), callBack);
//        } catch (JSONException e) {
//            e.printStackTrace();
//            if (listener != null) {
//                ErrorInfo errorInfo = new ErrorInfo();
//                errorInfo.setmMsg(Message.HTTP_ERROR_CREATE_JSON);
//                listener.onFailure(errorInfo);
//            }
//        }
//    }

    /**
     * 获取用户信息
     *
     * @param user
     * @param callBack
     */
//    public void getUserInfo(User user, MyCallBack callBack) {
//        String url = Api.GETUSERINFO + user.getmToken();
//        OkHttp.get(url, callBack);
//    }
//
//    /**
//     * 账号登出
//     * @param callBack
//     */
//    public void logout( MyCallBack callBack) {
//        String url = Api.LOGOUT +"?token="+ SPUserUtils.getString(AppConsts.SP_TOKEN);
//        OkHttp.get(url, callBack);
//    }

}
