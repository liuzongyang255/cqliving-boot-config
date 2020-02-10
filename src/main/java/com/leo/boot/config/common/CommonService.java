package com.leo.boot.config.common;

import org.cqliving.framework.cloud.mybatis.mvc.AbstractService;
import com.leo.boot.config.dal.entity.UserDO;
import com.leo.boot.config.error.LoginReultCode;
import cqliving.framework.cloud.core.error.BizException;

/********************************************************/
/*
FileName            :    CommonService.java                            
Project Name        :	 leo-boot-config                  
Author              :	 LiuZongYang                      
Mail                :    595324626@QQ.COM                 
Date                :    2020年2月11日 上午1:17:16                  
Version             :    1.0                              
Modification History:                                     
Date              Author        Version        Description
----------------------------------------------------------
2020年2月11日    LiuZongYang     1.0            新建
Brief Description: CommonService        						  
caution: something to be cautioned*/
/********************************************************/

public abstract class CommonService extends AbstractService{

    protected UserDO getUser() {
        UserDO user = (UserDO) request.getSession().getAttribute("user");
        if (null == user) {
            throw new BizException(LoginReultCode.USER_NOT_EXISTS);
        }
        return user;
    }
    
}

 
 