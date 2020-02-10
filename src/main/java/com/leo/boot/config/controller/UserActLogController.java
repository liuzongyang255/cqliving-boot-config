package com.leo.boot.config.controller;

import org.cqliving.framework.cloud.mybatis.result.PaginationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.leo.boot.config.common.CommonController;
import com.leo.boot.config.dal.dto.UserActLogDTO;
import com.leo.boot.config.dal.query.UserActLogQuery;
import com.leo.boot.config.service.UserActLogService;

/********************************************************/
/*
FileName            :    UserActLogController.java                            
Project Name        :	 leo-boot-config                  
Author              :	 LiuZongYang                      
Mail                :    595324626@QQ.COM                 
Date                :    2020年2月10日 下午7:27:15                  
Version             :    1.0                              
Modification History:                                     
Date              Author        Version        Description
----------------------------------------------------------
2020年2月10日    LiuZongYang     1.0            新建
Brief Description: UserActLogController        						  
caution: something to be cautioned*/
/********************************************************/

@Controller
@RequestMapping("user-act")
public class UserActLogController extends CommonController{
    
    @Autowired
    private UserActLogService userActLogService;
    
    @GetMapping("index")
    public String index() {
        return "";
    }
    
    @GetMapping("page")
    @ResponseBody
    public PaginationResponse<UserActLogDTO> page(UserActLogQuery query){
        return userActLogService.page(query);
    }
    

}

 
 
