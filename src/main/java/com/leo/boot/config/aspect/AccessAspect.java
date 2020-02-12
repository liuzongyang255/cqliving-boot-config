package com.leo.boot.config.aspect;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.cqliving.framework.cloud.mybatis.result.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.common.collect.Lists;
import com.leo.boot.config.error.LoginReultCode;

/********************************************************/
/*
FileName            :    UserActLogAspect.java                            
Project Name        :	 leo-boot-config                  
Author              :	 LiuZongYang                      
Mail                :    595324626@QQ.COM                 
Date                :    2020年2月10日 下午11:34:32                  
Version             :    1.0                              
Modification History:                                     
Date              Author        Version        Description
----------------------------------------------------------
2020年2月10日    LiuZongYang     1.0            新建
Brief Description: 用户操作日志切面				  
caution: something to be cautioned*/
/********************************************************/

@Aspect
@Component
public class AccessAspect {
    
    private static final Logger logger = LoggerFactory.getLogger(AccessAspect.class);
    
    @Autowired
    private HttpServletRequest request;
    
    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void accessPointCut() {}
    
    private static List<String> allowUrls = Lists.newArrayList("/login");
    
    @Around("accessPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object user = request.getSession().getAttribute("user");
        String url = request.getRequestURI();
        if (!allowUrls.contains(url) && null == user) {
            logger.warn("非法访问");
            return BaseResponse.newResponse(LoginReultCode.USER_LOGIN_TIMEOUT);
        }
        return point.proceed();
    }
    
}

 
 
