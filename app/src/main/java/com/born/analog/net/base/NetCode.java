package com.born.analog.net.base;

/**
 * created by born on 201811.
 * 返回码
 */
public class NetCode {

    public static boolean CheckCode(int code){

        if(code == 0 || code==200){
            return true;
        }
        boolean isSuccess = false;
       switch (code){
           case 0x0000: //ok
               isSuccess = true;
               break;
           case 0x0100://用户已经存在
               isSuccess = false;
               break;
           case 0x0101://非法手机号
               isSuccess = false;
               break;
           case 0x0102://发送异常
               isSuccess = false;
               break;
           case 0x0103://密码不正确
               isSuccess = false;
               break;
           case 0x0104://验证码错误
               isSuccess = false;
               break;
           case 0x0105://超时重新登录
               break;
           default://其它错误
               break;
       }

        return isSuccess;
    }
}
