package com.leo.boot.config.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/********************************************************/
/*
FileName            :    UserActLog.java                            
Project Name        :	 leo-boot-config                  
Author              :	 LiuZongYang                      
Mail                :    595324626@QQ.COM                 
Date                :    2020年2月10日 下午11:36:54                  
Version             :    1.0                              
Modification History:                                     
Date              Author        Version        Description
----------------------------------------------------------
2020年2月10日    LiuZongYang     1.0            新建
Brief Description: 用户操作日志注解        						  
caution: something to be cautioned*/
/********************************************************/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserActLog {

    /**
     * [方法名]api名
     * @author     leo
     * @since      2020年2月10日 下午11:38:34
     * @return
     */
    String apiName();
    
    /**
     * [方法名]api url
     * @author     leo
     * @since      2020年2月10日 下午11:38:34
     * @return
     */
    String apiUrl();
    
}

 
 
