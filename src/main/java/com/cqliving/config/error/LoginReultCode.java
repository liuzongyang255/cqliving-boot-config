package com.cqliving.config.error;

import cqliving.framework.cloud.core.result.ResponseMsgAble;

/********************************************************/
/*
FileName            :    LoginReultCode.java                            
Project Name        :	 leo-boot-config                  
Author              :	 LiuZongYang                      
Mail                :    595324626@QQ.COM                 
Date                :    2020年2月10日 下午3:58:11                  
Version             :    1.0                              
Modification History:                                     
Date              Author        Version        Description
----------------------------------------------------------
2020年2月10日    LiuZongYang     1.0            新建
Brief Description: TODO        						  
caution: something to be cautioned*/
/********************************************************/

/**
 * 10开头的为登录返回码
 * @author leo
 */
public enum LoginReultCode implements ResponseMsgAble{

    USER_NOT_EXISTS(101, "用户不存在"),
    USER_PASS_ERROR(102, "密码错误"),
    USER_LOGIN_TIMEOUT(103, "登录过期或无权访问"),
    USER_NAME_EXISTS(104, "用户名已存在"),
    USER_PASS2_ERROR(105, "两次密码不一致"),
    ;
    
    private int code;
    
    private String msg;
    
    LoginReultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return msg;
    }

}

 
 
