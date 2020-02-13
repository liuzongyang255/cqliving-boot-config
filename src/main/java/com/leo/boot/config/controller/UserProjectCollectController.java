package com.leo.boot.config.controller;

import javax.validation.constraints.NotNull;
import org.cqliving.framework.cloud.mybatis.result.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.leo.boot.config.common.CommonController;
import com.leo.boot.config.dal.entity.UserProjectCollectDO;
import com.leo.boot.config.service.UserProjectCollectService;

/********************************************************/
/*
FileName            :    UserProjectCollectController.java                            
Project Name        :	 leo-boot-config                  
Author              :	 LiuZongYang                      
Mail                :    595324626@QQ.COM                 
Date                :    2020年2月11日 下午2:15:42                  
Version             :    1.0                              
Modification History:                                     
Date              Author        Version        Description
----------------------------------------------------------
2020年2月11日    LiuZongYang     1.0            新建
Brief Description: UserProjectCollectController        						  
caution: something to be cautioned*/
/********************************************************/

@Controller
@RequestMapping("collect")
@Validated
public class UserProjectCollectController extends CommonController{

    @Autowired
    private UserProjectCollectService collectService;
    
    @PostMapping("save")
    @ResponseBody
    public BaseResponse save(@NotNull(message = "项目id不能为空") Long projectId, boolean cl) {
        Long userId = getUser().getId();
        try {
            if (cl) {
                UserProjectCollectDO collectDO = new UserProjectCollectDO();
                collectDO.setUserId(userId);
                collectDO.setProjectId(projectId);
                collectService.insert(collectDO);
            }else {
                collectService.deleteByUserIdAndProjectId(userId, projectId);
            }
        } catch (Exception e) {
            logger.warn("收藏失败:userId:{}, projectId:{}", userId, projectId);
        }
        return success();
    }
    
}

 
 
