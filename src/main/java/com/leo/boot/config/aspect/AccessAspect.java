package com.leo.boot.config.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    
    @Autowired
    private HttpServletResponse response;

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) or @annotation(org.springframework.web.bind.annotation.PostMapping) or @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void logPointCut() {}
    
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        if (null == request.getSession().getAttribute("user")) {
            response.sendRedirect("login");
            logger.warn("非法访问");
            return null;
        }
        return point.proceed();
    }
    
}

 
 
