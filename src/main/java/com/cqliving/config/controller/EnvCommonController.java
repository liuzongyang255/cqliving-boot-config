package com.cqliving.config.controller;

import org.cqliving.framework.cloud.mybatis.result.BaseResponse;
import org.cqliving.framework.cloud.mybatis.result.ListResponse;
import org.cqliving.framework.cloud.mybatis.result.PaginationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqliving.config.aspect.UserActLog;
import com.cqliving.config.common.CommonController;
import com.cqliving.config.dal.dto.EnvCommonDTO;
import com.cqliving.config.dal.query.EnvCommonQuery;
import com.cqliving.config.service.EnvCommonService;

/********************************************************/
/*
FileName            :    EnvCommonController.java                            
Project Name        :	 leo-boot-config                  
Author              :	 LiuZongYang                      
Mail                :    595324626@QQ.COM                 
Date                :    2020年2月12日 下午10:52:46                  
Version             :    1.0                              
Modification History:                                     
Date              Author        Version        Description
----------------------------------------------------------
2020年2月12日    LiuZongYang     1.0            新建
Brief Description: 公共配置管理        						  
caution: something to be cautioned*/
/********************************************************/

@Controller
@RequestMapping("common-env")
public class EnvCommonController extends CommonController{

    @Autowired
    private EnvCommonService commonService;
    
    @GetMapping("")
    public String index() {
        return "commonEnv/index";
    }
    
    @GetMapping("page")
    @ResponseBody
    public PaginationResponse<EnvCommonDTO> page(EnvCommonQuery query) {
        return commonService.page(query);
    }
    
    @GetMapping("listWithUsed")
    @ResponseBody
    public ListResponse<EnvCommonDTO> listWithUsed(Long envId) {
        return success(commonService.listWithUsed(envId));
    }
    
    @PostMapping("save")
    @ResponseBody
    @UserActLog("保存公共配置")
    public BaseResponse save(EnvCommonDTO dto) {
        commonService.save(dto);
        return success();
    }
    
    @PostMapping("del")
    @ResponseBody
    @UserActLog("删除公共配置")
    public BaseResponse del(Long id) {
        commonService.deleteById(id);
        return success();
    }
    
}

 
 
