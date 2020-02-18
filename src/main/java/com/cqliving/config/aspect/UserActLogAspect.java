package com.cqliving.config.aspect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;
import com.cqliving.config.dal.entity.UserActLogDO;
import com.cqliving.config.dal.entity.UserDO;
import com.cqliving.config.service.UserActLogService;

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
public class UserActLogAspect {
    
    private static final Logger logger = LoggerFactory.getLogger(UserActLogAspect.class);
    
    @Autowired
    private UserActLogService userActLogService;
    @Autowired
    private HttpServletRequest request;
    
    @Pointcut("@annotation(com.cqliving.config.aspect.UserActLog)")
    public void logPointCut() {}
    
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        try {
            saveLog(point);
        } catch (Exception e) {
            logger.warn("保存日志失败:{}",e);
        }
        return result;
    }
    
    /**
     * 保存日志
     * @param joinPoint
     */
    private void saveLog(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        
        UserActLogDO log = new UserActLogDO();
        log.setCreateTime(new Date());
        UserActLog ann = method.getAnnotation(UserActLog.class);
        log.setApiName(ann.apiName());
        log.setApiUrl(ann.apiUrl());
        //请求的参数
        Object[] args = joinPoint.getArgs();
        List<String> list = new ArrayList<>();
        for (Object o : args) {
            list.add(JSON.toJSONString(o));
        }
        log.setParams(list.toString());
        UserDO user = (UserDO) request.getSession().getAttribute("user");
        if (null != user && null != user.getId()) {
            log.setUserId(user.getId());
            userActLogService.insert(log);
        }
    }
    
}

 
 
