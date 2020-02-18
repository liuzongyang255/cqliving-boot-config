package com.cqliving.config.common;

import javax.servlet.http.HttpServletRequest;
import org.cqliving.framework.cloud.mybatis.mvc.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import com.cqliving.config.dal.entity.UserDO;
import com.cqliving.config.error.LoginReultCode;
import cqliving.framework.cloud.core.error.BizException;

/********************************************************/
/*
FileName            :    CommonController.java                            
Project Name        :	 leo-boot-config                  
Author              :	 LiuZongYang                      
Mail                :    595324626@QQ.COM                 
Date                :    2020年2月11日 上午1:17:16                  
Version             :    1.0                              
Modification History:                                     
Date              Author        Version        Description
----------------------------------------------------------
2020年2月11日    LiuZongYang     1.0            新建
Brief Description: CommonController        						  
caution: something to be cautioned*/
/********************************************************/

public abstract class CommonController extends AbstractController{

    @Autowired
    protected HttpServletRequest request;
    
    protected UserDO getUser() {
        UserDO user = (UserDO) request.getSession().getAttribute("user");
        if (null == user) {
            throw new BizException(LoginReultCode.USER_NOT_EXISTS);
        }
        return user;
    }
    
}

 
 
